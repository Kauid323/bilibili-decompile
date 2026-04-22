package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.tencent.matrix.report.Issue;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import java.text.MessageFormat;
import java.util.logging.Level;

final class ChannelLoggerImpl extends ChannelLogger {
    private final TimeProvider time;
    private final ChannelTracer tracer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelLoggerImpl(ChannelTracer tracer, TimeProvider time) {
        this.tracer = (ChannelTracer) Preconditions.checkNotNull(tracer, "tracer");
        this.time = (TimeProvider) Preconditions.checkNotNull(time, Issue.ISSUE_REPORT_TIME);
    }

    @Override // io.grpc.ChannelLogger
    public void log(ChannelLogger.ChannelLogLevel level, String msg) {
        logOnly(this.tracer.getLogId(), level, msg);
        if (isTraceable(level)) {
            trace(level, msg);
        }
    }

    @Override // io.grpc.ChannelLogger
    public void log(ChannelLogger.ChannelLogLevel level, String messageFormat, Object... args) {
        String msg = null;
        Level javaLogLevel = toJavaLogLevel(level);
        if (isTraceable(level) || ChannelTracer.logger.isLoggable(javaLogLevel)) {
            msg = MessageFormat.format(messageFormat, args);
        }
        log(level, msg);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void logOnly(InternalLogId logId, ChannelLogger.ChannelLogLevel level, String msg) {
        Level javaLogLevel = toJavaLogLevel(level);
        if (ChannelTracer.logger.isLoggable(javaLogLevel)) {
            ChannelTracer.logOnly(logId, javaLogLevel, msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void logOnly(InternalLogId logId, ChannelLogger.ChannelLogLevel level, String messageFormat, Object... args) {
        Level javaLogLevel = toJavaLogLevel(level);
        if (ChannelTracer.logger.isLoggable(javaLogLevel)) {
            String msg = MessageFormat.format(messageFormat, args);
            ChannelTracer.logOnly(logId, javaLogLevel, msg);
        }
    }

    private boolean isTraceable(ChannelLogger.ChannelLogLevel level) {
        return level != ChannelLogger.ChannelLogLevel.DEBUG && this.tracer.isTraceEnabled();
    }

    private void trace(ChannelLogger.ChannelLogLevel level, String msg) {
        if (level == ChannelLogger.ChannelLogLevel.DEBUG) {
            return;
        }
        this.tracer.traceOnly(new InternalChannelz.ChannelTrace.Event.Builder().setDescription(msg).setSeverity(toTracerSeverity(level)).setTimestampNanos(this.time.currentTimeNanos()).build());
    }

    private static InternalChannelz.ChannelTrace.Event.Severity toTracerSeverity(ChannelLogger.ChannelLogLevel level) {
        switch (level) {
            case ERROR:
                return InternalChannelz.ChannelTrace.Event.Severity.CT_ERROR;
            case WARNING:
                return InternalChannelz.ChannelTrace.Event.Severity.CT_WARNING;
            default:
                return InternalChannelz.ChannelTrace.Event.Severity.CT_INFO;
        }
    }

    private static Level toJavaLogLevel(ChannelLogger.ChannelLogLevel level) {
        switch (level) {
            case ERROR:
                return Level.FINE;
            case WARNING:
                return Level.FINER;
            default:
                return Level.FINEST;
        }
    }
}