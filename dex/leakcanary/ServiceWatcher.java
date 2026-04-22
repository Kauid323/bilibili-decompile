package leakcanary;

import android.app.Service;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.HandlersKt;
import shark.SharkLog;

/* compiled from: ServiceWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0013H\u0002J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0014H\u0002J&\u0010$\u001a\u00020\u001d2\u001c\u0010%\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0&H\u0003J \u0010'\u001a\u00020\u001d2\u0016\u0010%\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0006\u0012\u0004\u0018\u00010)0(H\u0002J\b\u0010*\u001a\u00020\u001dH\u0016R+\u0010\u0005\u001a\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lleakcanary/ServiceWatcher;", "Lleakcanary/InstallableWatcher;", "reachabilityWatcher", "Lleakcanary/ReachabilityWatcher;", "(Lleakcanary/ReachabilityWatcher;)V", "activityThreadClass", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "getActivityThreadClass", "()Ljava/lang/Class;", "activityThreadClass$delegate", "Lkotlin/Lazy;", "activityThreadInstance", "", "getActivityThreadInstance", "()Ljava/lang/Object;", "activityThreadInstance$delegate", "activityThreadServices", "", "Landroid/os/IBinder;", "Landroid/app/Service;", "getActivityThreadServices", "()Ljava/util/Map;", "activityThreadServices$delegate", "servicesToBeDestroyed", "Ljava/util/WeakHashMap;", "Ljava/lang/ref/WeakReference;", "uninstallActivityManager", "Lkotlin/Function0;", "", "uninstallActivityThreadHandlerCallback", "install", "onServiceDestroyed", "token", "onServicePreDestroy", "service", "swapActivityManager", "swap", "Lkotlin/Function2;", "swapActivityThreadHandlerCallback", "Lkotlin/Function1;", "Landroid/os/Handler$Callback;", "uninstall", "Companion", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class ServiceWatcher implements InstallableWatcher {
    public static final Companion Companion = new Companion(null);
    private static final String METHOD_SERVICE_DONE_EXECUTING = "serviceDoneExecuting";
    private static final int STOP_SERVICE = 116;
    private final Lazy activityThreadClass$delegate;
    private final Lazy activityThreadInstance$delegate;
    private final Lazy activityThreadServices$delegate;
    private final ReachabilityWatcher reachabilityWatcher;
    private final WeakHashMap<IBinder, WeakReference<Service>> servicesToBeDestroyed;
    private Function0<Unit> uninstallActivityManager;
    private Function0<Unit> uninstallActivityThreadHandlerCallback;

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getActivityThreadClass() {
        return (Class) this.activityThreadClass$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getActivityThreadInstance() {
        return this.activityThreadInstance$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<IBinder, Service> getActivityThreadServices() {
        return (Map) this.activityThreadServices$delegate.getValue();
    }

    public ServiceWatcher(ReachabilityWatcher reachabilityWatcher) {
        Intrinsics.checkParameterIsNotNull(reachabilityWatcher, "reachabilityWatcher");
        this.reachabilityWatcher = reachabilityWatcher;
        this.servicesToBeDestroyed = new WeakHashMap<>();
        this.activityThreadClass$delegate = LazyKt.lazy(new Function0<Class<?>>() { // from class: leakcanary.ServiceWatcher$activityThreadClass$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Class<?> invoke() {
                return Class.forName("android.app.ActivityThread");
            }
        });
        this.activityThreadInstance$delegate = LazyKt.lazy(new Function0<Object>() { // from class: leakcanary.ServiceWatcher$activityThreadInstance$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Class activityThreadClass;
                activityThreadClass = ServiceWatcher.this.getActivityThreadClass();
                Object invoke = activityThreadClass.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                if (invoke == null) {
                    Intrinsics.throwNpe();
                }
                return invoke;
            }
        });
        this.activityThreadServices$delegate = LazyKt.lazy(new Function0<Map<IBinder, ? extends Service>>() { // from class: leakcanary.ServiceWatcher$activityThreadServices$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<IBinder, ? extends Service> invoke() {
                Class activityThreadClass;
                Object activityThreadInstance;
                activityThreadClass = ServiceWatcher.this.getActivityThreadClass();
                Field mServicesField = activityThreadClass.getDeclaredField("mServices");
                mServicesField.setAccessible(true);
                activityThreadInstance = ServiceWatcher.this.getActivityThreadInstance();
                Object obj = mServicesField.get(activityThreadInstance);
                if (obj != null) {
                    return (Map) obj;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<android.os.IBinder, android.app.Service>");
            }
        });
    }

    @Override // leakcanary.InstallableWatcher
    public void install() {
        HandlersKt.checkMainThread();
        if (!(this.uninstallActivityThreadHandlerCallback == null)) {
            throw new IllegalStateException("ServiceWatcher already installed".toString());
        }
        if (!(this.uninstallActivityManager == null)) {
            throw new IllegalStateException("ServiceWatcher already installed".toString());
        }
        try {
            swapActivityThreadHandlerCallback(new Function1<Handler.Callback, Handler.Callback>() { // from class: leakcanary.ServiceWatcher$install$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Handler.Callback invoke(final Handler.Callback mCallback) {
                    ServiceWatcher.this.uninstallActivityThreadHandlerCallback = new Function0<Unit>() { // from class: leakcanary.ServiceWatcher$install$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ServiceWatcher.this.swapActivityThreadHandlerCallback(new Function1<Handler.Callback, Handler.Callback>() { // from class: leakcanary.ServiceWatcher.install.3.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Handler.Callback invoke(Handler.Callback it) {
                                    return mCallback;
                                }
                            });
                        }
                    };
                    return new Handler.Callback() { // from class: leakcanary.ServiceWatcher$install$3.2
                        @Override // android.os.Handler.Callback
                        public final boolean handleMessage(Message msg) {
                            Map activityThreadServices;
                            Intrinsics.checkParameterIsNotNull(msg, "msg");
                            if (msg.obj instanceof IBinder) {
                                if (msg.what == 116) {
                                    Object obj = msg.obj;
                                    if (obj != null) {
                                        IBinder key = (IBinder) obj;
                                        activityThreadServices = ServiceWatcher.this.getActivityThreadServices();
                                        Service it = (Service) activityThreadServices.get(key);
                                        if (it != null) {
                                            ServiceWatcher.this.onServicePreDestroy(key, it);
                                        }
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type android.os.IBinder");
                                    }
                                }
                                Handler.Callback callback = mCallback;
                                if (callback != null) {
                                    return callback.handleMessage(msg);
                                }
                                return false;
                            }
                            return false;
                        }
                    };
                }
            });
            swapActivityManager(new Function2<Class<?>, Object, Object>() { // from class: leakcanary.ServiceWatcher$install$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Class<?> activityManagerInterface, final Object activityManagerInstance) {
                    Intrinsics.checkParameterIsNotNull(activityManagerInterface, "activityManagerInterface");
                    Intrinsics.checkParameterIsNotNull(activityManagerInstance, "activityManagerInstance");
                    ServiceWatcher.this.uninstallActivityManager = new Function0<Unit>() { // from class: leakcanary.ServiceWatcher$install$4.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ServiceWatcher.this.swapActivityManager(new Function2<Class<?>, Object, Object>() { // from class: leakcanary.ServiceWatcher.install.4.1.1
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Class<?> cls, Object $noName_1) {
                                    Intrinsics.checkParameterIsNotNull(cls, "<anonymous parameter 0>");
                                    Intrinsics.checkParameterIsNotNull($noName_1, "<anonymous parameter 1>");
                                    return activityManagerInstance;
                                }
                            });
                        }
                    };
                    Object newProxyInstance = Proxy.newProxyInstance(activityManagerInterface.getClassLoader(), new Class[]{activityManagerInterface}, new InvocationHandler() { // from class: leakcanary.ServiceWatcher$install$4.2
                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object $noName_0, Method method, Object[] args) {
                            WeakHashMap weakHashMap;
                            Intrinsics.checkExpressionValueIsNotNull(method, "method");
                            if (Intrinsics.areEqual("serviceDoneExecuting", method.getName())) {
                                if (args == null) {
                                    Intrinsics.throwNpe();
                                }
                                Object obj = args[0];
                                if (obj != null) {
                                    IBinder token = (IBinder) obj;
                                    weakHashMap = ServiceWatcher.this.servicesToBeDestroyed;
                                    if (weakHashMap.containsKey(token)) {
                                        ServiceWatcher.this.onServiceDestroyed(token);
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type android.os.IBinder");
                                }
                            }
                            try {
                                if (args == null) {
                                    return method.invoke(activityManagerInstance, new Object[0]);
                                }
                                return method.invoke(activityManagerInstance, Arrays.copyOf(args, args.length));
                            } catch (InvocationTargetException invocationException) {
                                Throwable targetException = invocationException.getTargetException();
                                Intrinsics.checkExpressionValueIsNotNull(targetException, "invocationException.targetException");
                                throw targetException;
                            }
                        }
                    });
                    Intrinsics.checkExpressionValueIsNotNull(newProxyInstance, "Proxy.newProxyInstance(\n…ion\n          }\n        }");
                    return newProxyInstance;
                }
            });
        } catch (Throwable ignored) {
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d(ignored, "Could not watch destroyed services");
            }
        }
    }

    @Override // leakcanary.InstallableWatcher
    public void uninstall() {
        HandlersKt.checkMainThread();
        Function0<Unit> function0 = this.uninstallActivityManager;
        if (function0 != null) {
            function0.invoke();
        }
        Function0<Unit> function02 = this.uninstallActivityThreadHandlerCallback;
        if (function02 != null) {
            function02.invoke();
        }
        this.uninstallActivityManager = null;
        this.uninstallActivityThreadHandlerCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onServicePreDestroy(IBinder token, Service service) {
        this.servicesToBeDestroyed.put(token, new WeakReference<>(service));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onServiceDestroyed(IBinder token) {
        Service service;
        WeakReference serviceWeakReference = this.servicesToBeDestroyed.remove(token);
        if (serviceWeakReference != null && (service = serviceWeakReference.get()) != null) {
            ReachabilityWatcher reachabilityWatcher = this.reachabilityWatcher;
            Intrinsics.checkExpressionValueIsNotNull(service, "service");
            reachabilityWatcher.expectWeaklyReachable(service, service.getClass().getName() + " received Service#onDestroy() callback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void swapActivityThreadHandlerCallback(Function1<? super Handler.Callback, ? extends Handler.Callback> function1) {
        Field mHField = getActivityThreadClass().getDeclaredField("mH");
        mHField.setAccessible(true);
        Object obj = mHField.get(getActivityThreadInstance());
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.os.Handler");
        }
        Handler mH = (Handler) obj;
        Field mCallbackField = Handler.class.getDeclaredField("mCallback");
        mCallbackField.setAccessible(true);
        Handler.Callback mCallback = (Handler.Callback) mCallbackField.get(mH);
        mCallbackField.set(mH, function1.invoke(mCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void swapActivityManager(Function2<? super Class<?>, Object, ? extends Object> function2) {
        Pair pair;
        Class singletonClass = Class.forName("android.util.Singleton");
        Field mInstanceField = singletonClass.getDeclaredField("mInstance");
        mInstanceField.setAccessible(true);
        Method singletonGetMethod = singletonClass.getDeclaredMethod("get", new Class[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            pair = TuplesKt.to("android.app.ActivityManager", "IActivityManagerSingleton");
        } else {
            pair = TuplesKt.to("android.app.ActivityManagerNative", "gDefault");
        }
        String className = (String) pair.component1();
        String fieldName = (String) pair.component2();
        Class activityManagerClass = Class.forName(className);
        Field $this$apply = activityManagerClass.getDeclaredField(fieldName);
        $this$apply.setAccessible(true);
        Object activityManagerSingletonInstance = $this$apply.get(activityManagerClass);
        Object activityManagerInstance = singletonGetMethod.invoke(activityManagerSingletonInstance, new Object[0]);
        Class iActivityManagerInterface = Class.forName("android.app.IActivityManager");
        Intrinsics.checkExpressionValueIsNotNull(iActivityManagerInterface, "iActivityManagerInterface");
        if (activityManagerInstance == null) {
            Intrinsics.throwNpe();
        }
        mInstanceField.set(activityManagerSingletonInstance, function2.invoke(iActivityManagerInterface, activityManagerInstance));
    }

    /* compiled from: ServiceWatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lleakcanary/ServiceWatcher$Companion;", "", "()V", "METHOD_SERVICE_DONE_EXECUTING", "", "STOP_SERVICE", "", "leakcanary-object-watcher-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}