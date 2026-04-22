package curtains.internal;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowSpy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011R!\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcurtains/internal/WindowSpy;", "", "()V", "decorViewClass", "Ljava/lang/Class;", "getDecorViewClass", "()Ljava/lang/Class;", "decorViewClass$delegate", "Lkotlin/Lazy;", "windowField", "Ljava/lang/reflect/Field;", "getWindowField", "()Ljava/lang/reflect/Field;", "windowField$delegate", "attachedToPhoneWindow", "", "maybeDecorView", "Landroid/view/View;", "pullWindow", "Landroid/view/Window;", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class WindowSpy {
    public static final WindowSpy INSTANCE = new WindowSpy();
    private static final Lazy decorViewClass$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Class<?>>() { // from class: curtains.internal.WindowSpy$decorViewClass$2
        /* renamed from: invoke */
        public final Class<?> m789invoke() {
            String decorViewClassName;
            int sdkInt = Build.VERSION.SDK_INT;
            if (sdkInt >= 24) {
                decorViewClassName = "com.android.internal.policy.DecorView";
            } else {
                decorViewClassName = sdkInt == 23 ? "com.android.internal.policy.PhoneWindow$DecorView" : "com.android.internal.policy.impl.PhoneWindow$DecorView";
            }
            try {
                return Class.forName(decorViewClassName);
            } catch (Throwable ignored) {
                Log.d("WindowSpy", "Unexpected exception loading " + decorViewClassName + " on API " + sdkInt, ignored);
                return null;
            }
        }
    });
    private static final Lazy windowField$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Field>() { // from class: curtains.internal.WindowSpy$windowField$2
        public final Field invoke() {
            Class decorViewClass;
            decorViewClass = WindowSpy.INSTANCE.getDecorViewClass();
            if (decorViewClass != null) {
                int sdkInt = Build.VERSION.SDK_INT;
                String fieldName = sdkInt >= 24 ? "mWindow" : "this$0";
                try {
                    Field $this$apply = decorViewClass.getDeclaredField(fieldName);
                    $this$apply.setAccessible(true);
                    return $this$apply;
                } catch (NoSuchFieldException ignored) {
                    Log.d("WindowSpy", "Unexpected exception retrieving " + decorViewClass + '#' + fieldName + " on API " + sdkInt, ignored);
                    return null;
                }
            }
            return null;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getDecorViewClass() {
        return (Class) decorViewClass$delegate.getValue();
    }

    private final Field getWindowField() {
        return (Field) windowField$delegate.getValue();
    }

    private WindowSpy() {
    }

    public final boolean attachedToPhoneWindow(View maybeDecorView) {
        Intrinsics.checkNotNullParameter(maybeDecorView, "maybeDecorView");
        Class decorViewClass = getDecorViewClass();
        if (decorViewClass != null) {
            return decorViewClass.isInstance(maybeDecorView);
        }
        return false;
    }

    public final Window pullWindow(View maybeDecorView) {
        Field windowField;
        Intrinsics.checkNotNullParameter(maybeDecorView, "maybeDecorView");
        Class decorViewClass = getDecorViewClass();
        if (decorViewClass == null || !decorViewClass.isInstance(maybeDecorView) || (windowField = INSTANCE.getWindowField()) == null) {
            return null;
        }
        Object obj = windowField.get(maybeDecorView);
        if (obj != null) {
            return (Window) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.Window");
    }
}