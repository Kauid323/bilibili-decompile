package retrofit2;

import java.lang.reflect.Method;

public class RetrofitKt {
    public static Object invokeLoadServiceMethod(Retrofit retrofit, Method method, Object[] args) {
        return retrofit.loadServiceMethod(method).invoke(args);
    }
}