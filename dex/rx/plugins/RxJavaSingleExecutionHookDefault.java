package rx.plugins;

/* JADX INFO: Access modifiers changed from: package-private */
public final class RxJavaSingleExecutionHookDefault extends RxJavaSingleExecutionHook {
    private static final RxJavaSingleExecutionHookDefault INSTANCE = new RxJavaSingleExecutionHookDefault();

    private RxJavaSingleExecutionHookDefault() {
    }

    public static RxJavaSingleExecutionHook getInstance() {
        return INSTANCE;
    }
}