package tv.danmaku.biliplayerv2.service.interact.biz.model.comment;

public final class CommentItemFactory {
    public static CommentItem createComment(int type) {
        switch (type) {
            case 1:
                return new FlyToLeftCommentItem();
            case 2:
            case 3:
            default:
                return new NullCommentItem(type);
            case 4:
                return new BottomCommentItem();
            case 5:
                return new TopCommentItem();
            case 6:
                return new FlyToRightCommentItem();
            case 7:
                return new AbsoluteCommentItem();
        }
    }
}