package bolts;

import bolts.Task;

/* JADX INFO: Access modifiers changed from: package-private */
public class UnobservedErrorNotifier {
    private Task<?> task;

    public UnobservedErrorNotifier(Task<?> task) {
        this.task = task;
    }

    protected void finalize() throws Throwable {
        Task.UnobservedExceptionHandler ueh;
        try {
            Task faultedTask = this.task;
            if (faultedTask != null && (ueh = Task.getUnobservedExceptionHandler()) != null) {
                ueh.unobservedException(faultedTask, new UnobservedTaskException(faultedTask.getError()));
            }
        } finally {
            super.finalize();
        }
    }

    public void setObserved() {
        this.task = null;
    }
}