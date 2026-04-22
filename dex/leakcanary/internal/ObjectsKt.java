package leakcanary.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Objects.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001a\u0010\u0002\u001a\u0002H\u0003\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004H\u0080\b¢\u0006\u0002\u0010\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"NO_OP_HANDLER", "Ljava/lang/reflect/InvocationHandler;", "noOpDelegate", "T", "", "()Ljava/lang/Object;", "leakcanary-android-utils_release"}, k = 2, mv = {1, 4, 1})
public final class ObjectsKt {
    private static final InvocationHandler NO_OP_HANDLER = new InvocationHandler() { // from class: leakcanary.internal.ObjectsKt$NO_OP_HANDLER$1
        @Override // java.lang.reflect.InvocationHandler
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Method method, Object[] objArr) {
            invoke(obj, method, objArr);
            return Unit.INSTANCE;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final void invoke(Object $noName_0, Method $noName_1, Object[] $noName_2) {
        }
    };

    public static final /* synthetic */ InvocationHandler access$getNO_OP_HANDLER$p() {
        return NO_OP_HANDLER;
    }

    public static final /* synthetic */ <T> T noOpDelegate() {
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) Proxy.newProxyInstance(Object.class.getClassLoader(), new Class[]{Object.class}, NO_OP_HANDLER);
        Intrinsics.reifiedOperationMarker(1, "T");
        return t;
    }
}