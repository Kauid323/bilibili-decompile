package curtains.internal;

import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowManagerSpy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0012\u001a\u00020\u001322\u0010\u0014\u001a.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00180\u0015H\u0007J\u0011\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u001a¢\u0006\u0002\u0010\u001bR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R!\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcurtains/internal/WindowManagerSpy;", "", "()V", "mViewsField", "Ljava/lang/reflect/Field;", "getMViewsField", "()Ljava/lang/reflect/Field;", "mViewsField$delegate", "Lkotlin/Lazy;", "windowManagerClass", "Ljava/lang/Class;", "getWindowManagerClass", "()Ljava/lang/Class;", "windowManagerClass$delegate", "windowManagerInstance", "getWindowManagerInstance", "()Ljava/lang/Object;", "windowManagerInstance$delegate", "swapWindowManagerGlobalMViews", "", "swap", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "windowManagerMViewsArray", "", "()[Landroid/view/View;", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class WindowManagerSpy {
    public static final WindowManagerSpy INSTANCE = new WindowManagerSpy();
    private static final Lazy windowManagerClass$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Class<?>>() { // from class: curtains.internal.WindowManagerSpy$windowManagerClass$2
        /* renamed from: invoke */
        public final Class<?> m788invoke() {
            try {
                return Class.forName("android.view.WindowManagerGlobal");
            } catch (Throwable ignored) {
                Log.w("WindowManagerSpy", ignored);
                return null;
            }
        }
    });
    private static final Lazy windowManagerInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Object>() { // from class: curtains.internal.WindowManagerSpy$windowManagerInstance$2
        public final Object invoke() {
            Class windowManagerClass;
            windowManagerClass = WindowManagerSpy.INSTANCE.getWindowManagerClass();
            if (windowManagerClass != null) {
                return windowManagerClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            }
            return null;
        }
    });
    private static final Lazy mViewsField$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Field>() { // from class: curtains.internal.WindowManagerSpy$mViewsField$2
        public final Field invoke() {
            Class windowManagerClass;
            windowManagerClass = WindowManagerSpy.INSTANCE.getWindowManagerClass();
            if (windowManagerClass != null) {
                Field $this$apply = windowManagerClass.getDeclaredField("mViews");
                $this$apply.setAccessible(true);
                return $this$apply;
            }
            return null;
        }
    });

    private final Field getMViewsField() {
        return (Field) mViewsField$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getWindowManagerClass() {
        return (Class) windowManagerClass$delegate.getValue();
    }

    private final Object getWindowManagerInstance() {
        return windowManagerInstance$delegate.getValue();
    }

    private WindowManagerSpy() {
    }

    public final void swapWindowManagerGlobalMViews(Function1<? super ArrayList<View>, ? extends ArrayList<View>> function1) {
        Field mViewsField;
        Intrinsics.checkNotNullParameter(function1, "swap");
        try {
            Object windowManagerInstance = getWindowManagerInstance();
            if (windowManagerInstance != null && (mViewsField = INSTANCE.getMViewsField()) != null) {
                Object obj = mViewsField.get(windowManagerInstance);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<android.view.View> /* = java.util.ArrayList<android.view.View> */");
                }
                ArrayList mViews = (ArrayList) obj;
                mViewsField.set(windowManagerInstance, function1.invoke(mViews));
            }
        } catch (Throwable ignored) {
            Log.w("WindowManagerSpy", ignored);
        }
    }

    public final View[] windowManagerMViewsArray() {
        int i2 = Build.VERSION.SDK_INT;
        return new View[0];
    }
}