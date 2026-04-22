package kotlin.reflect.jvm.internal;

/* JADX INFO: Access modifiers changed from: package-private */
public class Util {
    public static Object getEnumConstantByName(Class<? extends Enum<?>> enumClass, String name) {
        return Enum.valueOf(enumClass, name);
    }
}