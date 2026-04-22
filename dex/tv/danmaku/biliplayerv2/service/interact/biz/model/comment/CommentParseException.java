package tv.danmaku.biliplayerv2.service.interact.biz.model.comment;

import org.json.JSONException;

public final class CommentParseException extends Exception {
    private static final long serialVersionUID = 7349228166377147140L;

    public CommentParseException(String message) {
        super(message);
    }

    public CommentParseException(JSONException e) {
        super(e.toString());
    }
}