package tv.danmaku.android.log.internal;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.LogAdapter;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;

/* compiled from: JvmLogger.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J.\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J=\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001f0\u001e\"\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0002\u0010 J2\u0010!\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\nH\u0016J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006%²\u0006\n\u0010\u0015\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"Ltv/danmaku/android/log/internal/JvmLogger;", "Ltv/danmaku/android/log/internal/ILogger;", "()V", "adapters", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ltv/danmaku/android/log/LogAdapter;", "logInvoker", "Lkotlin/Function3;", "", "", "Lkotlin/Function0;", "", "getLogInvoker", "()Lkotlin/jvm/functions/Function3;", "setLogInvoker", "(Lkotlin/jvm/functions/Function3;)V", "addAdapter", "", "adapter", "event", AppConfig.HOST_TAG, "message", "flush", "log", "priority", "t", "", "logFormat", "fmt", "args", "", "", "(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "logLazy", "lazyMsg", "removeAdapter", "removeAllAdapters", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class JvmLogger implements ILogger {
    private final CopyOnWriteArrayList<LogAdapter> adapters = new CopyOnWriteArrayList<>();
    private Function3<? super Integer, ? super String, ? super Function0<Integer>, Unit> logInvoker = new Function3<Integer, String, Function0<? extends Integer>, Unit>() { // from class: tv.danmaku.android.log.internal.JvmLogger$logInvoker$1
        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
            invoke(((Number) p1).intValue(), (String) p2, (Function0) p3);
            return Unit.INSTANCE;
        }

        public final void invoke(int i, String str, Function0<Integer> function0) {
            Intrinsics.checkNotNullParameter(function0, "invoker");
            function0.invoke();
        }
    };

    public final Function3<Integer, String, Function0<Integer>, Unit> getLogInvoker() {
        return this.logInvoker;
    }

    public final void setLogInvoker(Function3<? super Integer, ? super String, ? super Function0<Integer>, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.logInvoker = function3;
    }

    @Override // tv.danmaku.android.log.internal.ILogger
    public void event(final String tag, final String message) {
        this.logInvoker.invoke(4, tag, new Function0<Integer>() { // from class: tv.danmaku.android.log.internal.JvmLogger$event$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Integer m301invoke() {
                Iterable iterable;
                String msg = String.valueOf(message);
                iterable = this.adapters;
                Iterable $this$forEach$iv = iterable;
                String str = tag;
                for (Object element$iv : $this$forEach$iv) {
                    LogAdapter it = (LogAdapter) element$iv;
                    it.event(str, msg);
                }
                return Integer.valueOf(msg.length());
            }
        });
    }

    @Override // tv.danmaku.android.log.internal.ILogger
    public void log(final int priority, final String tag, final Throwable t, final String message) {
        this.logInvoker.invoke(Integer.valueOf(priority), tag, new Function0<Integer>() { // from class: tv.danmaku.android.log.internal.JvmLogger$log$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Integer m302invoke() {
                Iterable iterable;
                String msg = String.valueOf(message);
                iterable = this.adapters;
                Iterable $this$forEach$iv = iterable;
                int i = priority;
                String str = tag;
                Throwable th = t;
                for (Object element$iv : $this$forEach$iv) {
                    LogAdapter it = (LogAdapter) element$iv;
                    if (it.isLoggable(i, str)) {
                        it.log(i, str, msg, th);
                    }
                }
                return Integer.valueOf(msg.length());
            }
        });
    }

    @Override // tv.danmaku.android.log.internal.ILogger
    public void logLazy(final int priority, final String tag, final Throwable t, final Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMsg");
        this.logInvoker.invoke(Integer.valueOf(priority), tag, new Function0<Integer>() { // from class: tv.danmaku.android.log.internal.JvmLogger$logLazy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            private static final String invoke$lambda$0(Lazy<String> lazy) {
                return (String) lazy.getValue();
            }

            /* renamed from: invoke */
            public final Integer m305invoke() {
                Iterable iterable;
                final Function0<Object> function02 = function0;
                Lazy message$delegate = LazyKt.lazy(new Function0<String>() { // from class: tv.danmaku.android.log.internal.JvmLogger$logLazy$1$message$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return function02.invoke().toString();
                    }
                });
                iterable = JvmLogger.this.adapters;
                Iterable $this$forEach$iv = iterable;
                int i = priority;
                String str = tag;
                Throwable th = t;
                for (Object element$iv : $this$forEach$iv) {
                    LogAdapter it = (LogAdapter) element$iv;
                    if (it.isLoggable(i, str)) {
                        it.log(i, str, invoke$lambda$0(message$delegate), th);
                    }
                }
                return Integer.valueOf(invoke$lambda$0(message$delegate).length());
            }
        });
    }

    @Override // tv.danmaku.android.log.internal.ILogger
    public void logFormat(final int priority, final String tag, final String fmt, final Object... args) {
        Intrinsics.checkNotNullParameter(tag, AppConfig.HOST_TAG);
        Intrinsics.checkNotNullParameter(fmt, "fmt");
        Intrinsics.checkNotNullParameter(args, "args");
        this.logInvoker.invoke(Integer.valueOf(priority), tag, new Function0<Integer>() { // from class: tv.danmaku.android.log.internal.JvmLogger$logFormat$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            private static final String invoke$lambda$0(Lazy<String> lazy) {
                return (String) lazy.getValue();
            }

            /* renamed from: invoke */
            public final Integer m303invoke() {
                Iterable iterable;
                final String str = fmt;
                final Object[] objArr = args;
                Lazy message$delegate = LazyKt.lazy(new Function0<String>() { // from class: tv.danmaku.android.log.internal.JvmLogger$logFormat$1$message$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        String str2 = str;
                        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                        String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        return format;
                    }
                });
                iterable = JvmLogger.this.adapters;
                Iterable $this$forEach$iv = iterable;
                int i = priority;
                String str2 = tag;
                JvmLogger jvmLogger = JvmLogger.this;
                for (Object element$iv : $this$forEach$iv) {
                    LogAdapter it = (LogAdapter) element$iv;
                    if (it.isLoggable(i, str2)) {
                        try {
                            it.log(i, str2, invoke$lambda$0(message$delegate), null);
                        } catch (RuntimeException e) {
                            jvmLogger.log(6, str2, e, "Format log string failed.");
                            return -1;
                        }
                    }
                }
                try {
                    return Integer.valueOf(invoke$lambda$0(message$delegate).length());
                } catch (RuntimeException e2) {
                    JvmLogger.this.log(6, tag, e2, "Format log string failed.");
                    return -1;
                }
            }
        });
    }

    @Override // tv.danmaku.android.log.internal.ILogger
    public void flush() {
        Iterable $this$forEach$iv = this.adapters;
        for (Object element$iv : $this$forEach$iv) {
            LogAdapter it = (LogAdapter) element$iv;
            it.flush();
        }
    }

    public final boolean addAdapter(LogAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        return this.adapters.add(adapter);
    }

    public final boolean removeAdapter(LogAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        return this.adapters.remove(adapter);
    }

    public final void removeAllAdapters() {
        this.adapters.clear();
    }
}