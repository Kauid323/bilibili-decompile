package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectJavaMember.kt */
public final class Java8ParameterNamesLoader {
    public static final Java8ParameterNamesLoader INSTANCE = new Java8ParameterNamesLoader();
    private static Cache cache;

    /* compiled from: ReflectJavaMember.kt */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Cache {
        private final Method getName;
        private final Method getParameters;

        public Cache(Method getParameters, Method getName) {
            this.getParameters = getParameters;
            this.getName = getName;
        }

        public final Method getGetName() {
            return this.getName;
        }

        public final Method getGetParameters() {
            return this.getParameters;
        }
    }

    private Java8ParameterNamesLoader() {
    }

    public final Cache buildCache(Member member) {
        Intrinsics.checkNotNullParameter(member, "member");
        Class methodOrConstructorClass = member.getClass();
        try {
            Method getParameters = methodOrConstructorClass.getMethod("getParameters", new Class[0]);
            Class parameterClass = ReflectClassUtilKt.getSafeClassLoader(methodOrConstructorClass).loadClass("java.lang.reflect.Parameter");
            return new Cache(getParameters, parameterClass.getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException e) {
            return new Cache(null, null);
        }
    }

    public final List<String> loadParameterNames(Member member) {
        Method getName;
        Cache it;
        Intrinsics.checkNotNullParameter(member, "member");
        Cache cache2 = cache;
        if (cache2 == null) {
            synchronized (this) {
                it = cache;
                if (it == null) {
                    it = INSTANCE.buildCache(member);
                    cache = it;
                }
            }
            cache2 = it;
        }
        Method getParameters = cache2.getGetParameters();
        if (getParameters == null || (getName = cache2.getGetName()) == null) {
            return null;
        }
        int i = 0;
        Object invoke = getParameters.invoke(member, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] $this$map$iv = (Object[]) invoke;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        int length = $this$map$iv.length;
        int i2 = 0;
        while (i2 < length) {
            Object item$iv$iv = $this$map$iv[i2];
            Object invoke2 = getName.invoke(item$iv$iv, new Object[i]);
            Intrinsics.checkNotNull(invoke2, "null cannot be cast to non-null type kotlin.String");
            destination$iv$iv.add((String) invoke2);
            i2++;
            i = 0;
        }
        return (List) destination$iv$iv;
    }
}