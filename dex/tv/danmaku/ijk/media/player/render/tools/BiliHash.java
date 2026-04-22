package tv.danmaku.ijk.media.player.render.tools;

import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;

public class BiliHash {
    private BiliRenderContext _glContext;
    private int _threadId;

    public BiliHash(int threadId, BiliRenderContext context) {
        this._threadId = threadId;
        this._glContext = context;
    }

    public boolean empty() {
        return this._glContext == null;
    }

    public boolean equal(BiliHash other) {
        return this._glContext == other._glContext && this._threadId == other._threadId;
    }

    public boolean isCurrentThread() {
        return !empty() && ((long) this._threadId) == Thread.currentThread().getId();
    }
}