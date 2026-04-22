package tv.danmaku.bili.ui;

public class LoaderResult<R> {
    public Exception error;
    public R response;

    public LoaderResult(Exception error) {
        this.error = error;
    }

    public LoaderResult(R response) {
        this.response = response;
    }
}