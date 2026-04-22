package tv.danmaku.bili.services.videodownload.exception;

import com.bilibili.lib.media.resolver.exception.ResolveException;

public class ResolveBangumiException extends ResolveException {
    public ResolveBangumiException(String detailMessage) {
        super(detailMessage);
    }

    public ResolveBangumiException(Throwable throwable) {
        super(throwable);
    }
}