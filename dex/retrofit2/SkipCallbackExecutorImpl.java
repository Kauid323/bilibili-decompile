package retrofit2;

import java.lang.annotation.Annotation;

/* JADX INFO: Access modifiers changed from: package-private */
public final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    private static final SkipCallbackExecutor INSTANCE = new SkipCallbackExecutorImpl();

    SkipCallbackExecutorImpl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Annotation[] ensurePresent(Annotation[] annotations) {
        if (Utils.isAnnotationPresent(annotations, SkipCallbackExecutor.class)) {
            return annotations;
        }
        Annotation[] newAnnotations = new Annotation[annotations.length + 1];
        newAnnotations[0] = INSTANCE;
        System.arraycopy(annotations, 0, newAnnotations, 1, annotations.length);
        return newAnnotations;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + SkipCallbackExecutor.class.getName() + "()";
    }
}