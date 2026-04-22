package io.reactivex.rxjava3.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.live.room.recommend.RoomRecommendViewModel;

public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public CompositeException(Throwable... exceptions) {
        this(exceptions == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(exceptions));
    }

    public CompositeException(Iterable<? extends Throwable> errors) {
        Set<Throwable> deDupedExceptions = new LinkedHashSet<>();
        if (errors != null) {
            for (Throwable ex : errors) {
                if (ex instanceof CompositeException) {
                    deDupedExceptions.addAll(((CompositeException) ex).getExceptions());
                } else if (ex != null) {
                    deDupedExceptions.add(ex);
                } else {
                    deDupedExceptions.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            deDupedExceptions.add(new NullPointerException("errors was null"));
        }
        if (deDupedExceptions.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        List<Throwable> localExceptions = new ArrayList<>(deDupedExceptions);
        this.exceptions = Collections.unmodifiableList(localExceptions);
        this.message = this.exceptions.size() + " exceptions occurred. ";
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        String[] split;
        if (this.cause == null) {
            String separator = System.getProperty("line.separator");
            if (this.exceptions.size() > 1) {
                Map<Throwable, Boolean> seenCauses = new IdentityHashMap<>();
                StringBuilder aggregateMessage = new StringBuilder();
                aggregateMessage.append("Multiple exceptions (").append(this.exceptions.size()).append(")").append(separator);
                for (Throwable inner : this.exceptions) {
                    int depth = 0;
                    while (true) {
                        if (inner != null) {
                            for (int i = 0; i < depth; i++) {
                                aggregateMessage.append("  ");
                            }
                            aggregateMessage.append("|-- ");
                            aggregateMessage.append(inner.getClass().getCanonicalName()).append(": ");
                            String innerMessage = inner.getMessage();
                            if (innerMessage != null && innerMessage.contains(separator)) {
                                aggregateMessage.append(separator);
                                for (String line : innerMessage.split(separator)) {
                                    for (int i2 = 0; i2 < depth + 2; i2++) {
                                        aggregateMessage.append("  ");
                                    }
                                    aggregateMessage.append(line).append(separator);
                                }
                            } else {
                                aggregateMessage.append(innerMessage);
                                aggregateMessage.append(separator);
                            }
                            for (int i3 = 0; i3 < depth + 2; i3++) {
                                aggregateMessage.append("  ");
                            }
                            StackTraceElement[] st = inner.getStackTrace();
                            if (st.length > 0) {
                                aggregateMessage.append("at ").append(st[0]).append(separator);
                            }
                            if (!seenCauses.containsKey(inner)) {
                                seenCauses.put(inner, true);
                                inner = inner.getCause();
                                depth++;
                            } else {
                                Throwable inner2 = inner.getCause();
                                if (inner2 != null) {
                                    for (int i4 = 0; i4 < depth + 2; i4++) {
                                        aggregateMessage.append("  ");
                                    }
                                    aggregateMessage.append("|-- ");
                                    aggregateMessage.append("(cause not expanded again) ");
                                    aggregateMessage.append(inner2.getClass().getCanonicalName()).append(": ");
                                    aggregateMessage.append(inner2.getMessage());
                                    aggregateMessage.append(separator);
                                }
                            }
                        }
                    }
                }
                this.cause = new ExceptionOverview(aggregateMessage.toString().trim());
            } else {
                this.cause = this.exceptions.get(0);
            }
        }
        return this.cause;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream s) {
        printStackTrace(new WrappedPrintStream(s));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter s) {
        printStackTrace(new WrappedPrintWriter(s));
    }

    private void printStackTrace(PrintStreamOrWriter s) {
        StackTraceElement[] stackTrace;
        StringBuilder b = new StringBuilder(128);
        b.append(this).append('\n');
        for (StackTraceElement myStackElement : getStackTrace()) {
            b.append("\tat ").append(myStackElement).append('\n');
        }
        int i = 1;
        for (Throwable ex : this.exceptions) {
            b.append("  ComposedException ").append(i).append(" :\n");
            appendStackTrace(b, ex, "\t");
            i++;
        }
        s.println(b.toString());
    }

    private void appendStackTrace(StringBuilder b, Throwable ex, String prefix) {
        StackTraceElement[] stackTrace;
        b.append(prefix).append(ex).append('\n');
        for (StackTraceElement stackElement : ex.getStackTrace()) {
            b.append("\t\tat ").append(stackElement).append('\n');
        }
        if (ex.getCause() != null) {
            b.append("\tCaused by: ");
            appendStackTrace(b, ex.getCause(), RoomRecommendViewModel.EMPTY_CURSOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class PrintStreamOrWriter {
        abstract void println(Object o);

        PrintStreamOrWriter() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        WrappedPrintStream(PrintStream printStream) {
            this.printStream = printStream;
        }

        @Override // io.reactivex.rxjava3.exceptions.CompositeException.PrintStreamOrWriter
        void println(Object o) {
            this.printStream.println(o);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter printWriter;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.printWriter = printWriter;
        }

        @Override // io.reactivex.rxjava3.exceptions.CompositeException.PrintStreamOrWriter
        void println(Object o) {
            this.printWriter.println(o);
        }
    }

    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    static final class ExceptionOverview extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        ExceptionOverview(String message) {
            super(message);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public int size() {
        return this.exceptions.size();
    }
}