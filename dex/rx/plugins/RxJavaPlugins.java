package rx.plugins;

import androidx.compose.animation.core.MutatorMutex$;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins {
    private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
    static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaErrorHandler() { // from class: rx.plugins.RxJavaPlugins.1
    };
    private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference<>();
    private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSingleExecutionHook> singleExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaCompletableExecutionHook> completableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference<>();

    @Deprecated
    public static RxJavaPlugins getInstance() {
        return INSTANCE;
    }

    RxJavaPlugins() {
    }

    public void reset() {
        INSTANCE.errorHandler.set(null);
        INSTANCE.observableExecutionHook.set(null);
        INSTANCE.singleExecutionHook.set(null);
        INSTANCE.completableExecutionHook.set(null);
        INSTANCE.schedulersHook.set(null);
    }

    public RxJavaErrorHandler getErrorHandler() {
        if (this.errorHandler.get() == null) {
            Object impl = getPluginImplementationViaProperty(RxJavaErrorHandler.class, System.getProperties());
            if (impl == null) {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.errorHandler, (Object) null, DEFAULT_ERROR_HANDLER);
            } else {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.errorHandler, (Object) null, (RxJavaErrorHandler) impl);
            }
        }
        return this.errorHandler.get();
    }

    public void registerErrorHandler(RxJavaErrorHandler impl) {
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.errorHandler, (Object) null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.errorHandler.get());
        }
    }

    public RxJavaObservableExecutionHook getObservableExecutionHook() {
        if (this.observableExecutionHook.get() == null) {
            Object impl = getPluginImplementationViaProperty(RxJavaObservableExecutionHook.class, System.getProperties());
            if (impl == null) {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observableExecutionHook, (Object) null, RxJavaObservableExecutionHookDefault.getInstance());
            } else {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observableExecutionHook, (Object) null, (RxJavaObservableExecutionHook) impl);
            }
        }
        return this.observableExecutionHook.get();
    }

    public void registerObservableExecutionHook(RxJavaObservableExecutionHook impl) {
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.observableExecutionHook, (Object) null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.observableExecutionHook.get());
        }
    }

    public RxJavaSingleExecutionHook getSingleExecutionHook() {
        if (this.singleExecutionHook.get() == null) {
            Object impl = getPluginImplementationViaProperty(RxJavaSingleExecutionHook.class, System.getProperties());
            if (impl == null) {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.singleExecutionHook, (Object) null, RxJavaSingleExecutionHookDefault.getInstance());
            } else {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.singleExecutionHook, (Object) null, (RxJavaSingleExecutionHook) impl);
            }
        }
        return this.singleExecutionHook.get();
    }

    public void registerSingleExecutionHook(RxJavaSingleExecutionHook impl) {
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.singleExecutionHook, (Object) null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
        }
    }

    public RxJavaCompletableExecutionHook getCompletableExecutionHook() {
        if (this.completableExecutionHook.get() == null) {
            Object impl = getPluginImplementationViaProperty(RxJavaCompletableExecutionHook.class, System.getProperties());
            if (impl == null) {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.completableExecutionHook, (Object) null, new RxJavaCompletableExecutionHook() { // from class: rx.plugins.RxJavaPlugins.2
                });
            } else {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.completableExecutionHook, (Object) null, (RxJavaCompletableExecutionHook) impl);
            }
        }
        return this.completableExecutionHook.get();
    }

    public void registerCompletableExecutionHook(RxJavaCompletableExecutionHook impl) {
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.completableExecutionHook, (Object) null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Object getPluginImplementationViaProperty(Class<?> pluginClass, Properties propsIn) {
        String classSuffix;
        Class<?> cls;
        Properties props = (Properties) propsIn.clone();
        String classSimpleName = pluginClass.getSimpleName();
        String defaultKey = "rxjava.plugin." + classSimpleName + ".implementation";
        String implementingClass = props.getProperty(defaultKey);
        if (implementingClass == null) {
            for (Map.Entry<Object, Object> e : props.entrySet()) {
                String key = e.getKey().toString();
                if (key.startsWith("rxjava.plugin.") && key.endsWith(".class")) {
                    String value = e.getValue().toString();
                    if (classSimpleName.equals(value)) {
                        String index = key.substring(0, key.length() - ".class".length()).substring("rxjava.plugin.".length());
                        String implKey = "rxjava.plugin." + index + ".impl";
                        String implementingClass2 = props.getProperty(implKey);
                        if (implementingClass2 != null) {
                            classSuffix = implementingClass2;
                            if (classSuffix == null) {
                                try {
                                    cls = Class.forName(classSuffix);
                                } catch (ClassCastException e2) {
                                    e = e2;
                                } catch (ClassNotFoundException e3) {
                                    e = e3;
                                } catch (IllegalAccessException e4) {
                                    e = e4;
                                } catch (InstantiationException e5) {
                                    e = e5;
                                }
                                try {
                                    return cls.asSubclass(pluginClass).newInstance();
                                } catch (ClassCastException e6) {
                                    e = e6;
                                    throw new IllegalStateException(classSimpleName + " implementation is not an instance of " + classSimpleName + ": " + classSuffix, e);
                                } catch (ClassNotFoundException e7) {
                                    e = e7;
                                    throw new IllegalStateException(classSimpleName + " implementation class not found: " + classSuffix, e);
                                } catch (IllegalAccessException e8) {
                                    e = e8;
                                    throw new IllegalStateException(classSimpleName + " implementation not able to be accessed: " + classSuffix, e);
                                } catch (InstantiationException e9) {
                                    e = e9;
                                    throw new IllegalStateException(classSimpleName + " implementation not able to be instantiated: " + classSuffix, e);
                                }
                            }
                            return null;
                        }
                        throw new IllegalStateException("Implementing class declaration for " + classSimpleName + " missing: " + implKey);
                    }
                }
            }
        }
        classSuffix = implementingClass;
        if (classSuffix == null) {
        }
    }

    public RxJavaSchedulersHook getSchedulersHook() {
        if (this.schedulersHook.get() == null) {
            Object impl = getPluginImplementationViaProperty(RxJavaSchedulersHook.class, System.getProperties());
            if (impl == null) {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.schedulersHook, (Object) null, RxJavaSchedulersHook.getDefaultInstance());
            } else {
                MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.schedulersHook, (Object) null, (RxJavaSchedulersHook) impl);
            }
        }
        return this.schedulersHook.get();
    }

    public void registerSchedulersHook(RxJavaSchedulersHook impl) {
        if (!MutatorMutex$.ExternalSyntheticBackportWithForwarding0.m(this.schedulersHook, (Object) null, impl)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
        }
    }
}