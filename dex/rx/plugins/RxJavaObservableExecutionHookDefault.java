package rx.plugins;

/* JADX INFO: Access modifiers changed from: package-private */
public final class RxJavaObservableExecutionHookDefault extends RxJavaObservableExecutionHook {
    private static final RxJavaObservableExecutionHookDefault INSTANCE = new RxJavaObservableExecutionHookDefault();

    private RxJavaObservableExecutionHookDefault() {
    }

    public static RxJavaObservableExecutionHook getInstance() {
        return INSTANCE;
    }
}