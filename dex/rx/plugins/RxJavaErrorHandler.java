package rx.plugins;

import rx.exceptions.Exceptions;

public abstract class RxJavaErrorHandler {
    protected static final String ERROR_IN_RENDERING_SUFFIX = ".errorRendering";

    @Deprecated
    public void handleError(Throwable e) {
    }

    public final String handleOnNextValueRendering(Object item) {
        try {
            return render(item);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return item.getClass().getName() + ERROR_IN_RENDERING_SUFFIX;
        } catch (Throwable t) {
            Exceptions.throwIfFatal(t);
            return item.getClass().getName() + ERROR_IN_RENDERING_SUFFIX;
        }
    }

    protected String render(Object item) throws InterruptedException {
        return null;
    }
}