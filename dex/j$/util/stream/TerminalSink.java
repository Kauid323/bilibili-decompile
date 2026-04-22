package j$.util.stream;

import java.util.function.Supplier;

/* JADX INFO: Access modifiers changed from: package-private */
public interface TerminalSink<T, R> extends Sink<T>, Supplier<R> {
}