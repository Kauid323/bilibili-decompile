package me.weishu.epic.art.entry;

import com.taobao.android.dexposed.utility.Debug;
import com.taobao.android.dexposed.utility.Logger;
import de.robv.android.xposed.DexposedBridge;
import de.robv.android.xposed.XposedHelpers;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import me.weishu.epic.art.Epic;
import me.weishu.epic.art.EpicNative;

public class Entry64_2 {
    private static final String TAG = "Entry64";
    private static Map<Class<?>, String> bridgeMethodMap = new HashMap();

    private static int onHookInt(Object artmethod, Object receiver, Object[] args) {
        return ((Integer) DexposedBridge.handleHookedArtMethod(artmethod, receiver, args)).intValue();
    }

    private static long onHookLong(Object artmethod, Object receiver, Object[] args) {
        return ((Long) DexposedBridge.handleHookedArtMethod(artmethod, receiver, args)).longValue();
    }

    private static double onHookDouble(Object artmethod, Object receiver, Object[] args) {
        return ((Double) DexposedBridge.handleHookedArtMethod(artmethod, receiver, args)).doubleValue();
    }

    private static char onHookChar(Object artmethod, Object receiver, Object[] args) {
        return ((Character) DexposedBridge.handleHookedArtMethod(artmethod, receiver, args)).charValue();
    }

    private static short onHookShort(Object artmethod, Object receiver, Object[] args) {
        return ((Short) DexposedBridge.handleHookedArtMethod(artmethod, receiver, args)).shortValue();
    }

    private static float onHookFloat(Object artmethod, Object receiver, Object[] args) {
        return ((Float) DexposedBridge.handleHookedArtMethod(artmethod, receiver, args)).floatValue();
    }

    private static Object onHookObject(Object artmethod, Object receiver, Object[] args) {
        return DexposedBridge.handleHookedArtMethod(artmethod, receiver, args);
    }

    private static void onHookVoid(Object artmethod, Object receiver, Object[] args) {
        DexposedBridge.handleHookedArtMethod(artmethod, receiver, args);
    }

    private static boolean onHookBoolean(Object artmethod, Object receiver, Object[] args) {
        return ((Boolean) DexposedBridge.handleHookedArtMethod(artmethod, receiver, args)).booleanValue();
    }

    private static byte onHookByte(Object artmethod, Object receiver, Object[] args) {
        return ((Byte) DexposedBridge.handleHookedArtMethod(artmethod, receiver, args)).byteValue();
    }

    private static void voidBridge(long x1, long struct) {
        referenceBridge(x1, struct, 0L, 0L, 0L, 0L, 0L);
    }

    private static void voidBridge(long x1, long struct, long x3) {
        referenceBridge(x1, struct, x3, 0L, 0L, 0L, 0L);
    }

    private static void voidBridge(long x1, long struct, long x3, long x4) {
        referenceBridge(x1, struct, x3, x4, 0L, 0L, 0L);
    }

    private static void voidBridge(long r1, long struct, long x3, long x4, long x5) {
        referenceBridge(r1, struct, x3, x4, x5, 0L, 0L);
    }

    private static void voidBridge(long r1, long struct, long x3, long x4, long x5, long x6) {
        referenceBridge(r1, struct, x3, x4, x5, x6, 0L);
    }

    private static void voidBridge(long r1, long struct, long x3, long x4, long x5, long x6, long x7) {
        referenceBridge(r1, struct, x3, x4, x5, x6, x7);
    }

    private static boolean booleanBridge(long x1, long struct) {
        return ((Boolean) referenceBridge(x1, struct, 0L, 0L, 0L, 0L, 0L)).booleanValue();
    }

    private static boolean booleanBridge(long x1, long struct, long x3) {
        return ((Boolean) referenceBridge(x1, struct, x3, 0L, 0L, 0L, 0L)).booleanValue();
    }

    private static boolean booleanBridge(long x1, long struct, long x3, long x4) {
        return ((Boolean) referenceBridge(x1, struct, x3, x4, 0L, 0L, 0L)).booleanValue();
    }

    private static boolean booleanBridge(long r1, long struct, long x3, long x4, long x5) {
        return ((Boolean) referenceBridge(r1, struct, x3, x4, x5, 0L, 0L)).booleanValue();
    }

    private static boolean booleanBridge(long r1, long struct, long x3, long x4, long x5, long x6) {
        return ((Boolean) referenceBridge(r1, struct, x3, x4, x5, x6, 0L)).booleanValue();
    }

    private static boolean booleanBridge(long r1, long struct, long x3, long x4, long x5, long x6, long x7) {
        return ((Boolean) referenceBridge(r1, struct, x3, x4, x5, x6, x7)).booleanValue();
    }

    private static byte byteBridge(long x1, long struct) {
        return ((Byte) referenceBridge(x1, struct, 0L, 0L, 0L, 0L, 0L)).byteValue();
    }

    private static byte byteBridge(long x1, long struct, long x3) {
        return ((Byte) referenceBridge(x1, struct, x3, 0L, 0L, 0L, 0L)).byteValue();
    }

    private static byte byteBridge(long x1, long struct, long x3, long x4) {
        return ((Byte) referenceBridge(x1, struct, x3, x4, 0L, 0L, 0L)).byteValue();
    }

    private static byte byteBridge(long r1, long struct, long x3, long x4, long x5) {
        return ((Byte) referenceBridge(r1, struct, x3, x4, x5, 0L, 0L)).byteValue();
    }

    private static byte byteBridge(long r1, long struct, long x3, long x4, long x5, long x6) {
        return ((Byte) referenceBridge(r1, struct, x3, x4, x5, x6, 0L)).byteValue();
    }

    private static byte byteBridge(long r1, long struct, long x3, long x4, long x5, long x6, long x7) {
        return ((Byte) referenceBridge(r1, struct, x3, x4, x5, x6, x7)).byteValue();
    }

    private static short shortBridge(long x1, long struct) {
        return ((Short) referenceBridge(x1, struct, 0L, 0L, 0L, 0L, 0L)).shortValue();
    }

    private static short shortBridge(long x1, long struct, long x3) {
        return ((Short) referenceBridge(x1, struct, x3, 0L, 0L, 0L, 0L)).shortValue();
    }

    private static short shortBridge(long x1, long struct, long x3, long x4) {
        return ((Short) referenceBridge(x1, struct, x3, x4, 0L, 0L, 0L)).shortValue();
    }

    private static short shortBridge(long r1, long struct, long x3, long x4, long x5) {
        return ((Short) referenceBridge(r1, struct, x3, x4, x5, 0L, 0L)).shortValue();
    }

    private static short shortBridge(long r1, long struct, long x3, long x4, long x5, long x6) {
        return ((Short) referenceBridge(r1, struct, x3, x4, x5, x6, 0L)).shortValue();
    }

    private static short shortBridge(long r1, long struct, long x3, long x4, long x5, long x6, long x7) {
        return ((Short) referenceBridge(r1, struct, x3, x4, x5, x6, x7)).shortValue();
    }

    private static char charBridge(long x1, long struct) {
        return ((Character) referenceBridge(x1, struct, 0L, 0L, 0L, 0L, 0L)).charValue();
    }

    private static char charBridge(long x1, long struct, long x3) {
        return ((Character) referenceBridge(x1, struct, x3, 0L, 0L, 0L, 0L)).charValue();
    }

    private static char charBridge(long x1, long struct, long x3, long x4) {
        return ((Character) referenceBridge(x1, struct, x3, x4, 0L, 0L, 0L)).charValue();
    }

    private static char charBridge(long r1, long struct, long x3, long x4, long x5) {
        return ((Character) referenceBridge(r1, struct, x3, x4, x5, 0L, 0L)).charValue();
    }

    private static char charBridge(long r1, long struct, long x3, long x4, long x5, long x6) {
        return ((Character) referenceBridge(r1, struct, x3, x4, x5, x6, 0L)).charValue();
    }

    private static char charBridge(long r1, long struct, long x3, long x4, long x5, long x6, long x7) {
        return ((Character) referenceBridge(r1, struct, x3, x4, x5, x6, x7)).charValue();
    }

    private static int intBridge(long x1, long struct) {
        return ((Integer) referenceBridge(x1, struct, 0L, 0L, 0L, 0L, 0L)).intValue();
    }

    private static int intBridge(long x1, long struct, long x3) {
        return ((Integer) referenceBridge(x1, struct, x3, 0L, 0L, 0L, 0L)).intValue();
    }

    private static int intBridge(long x1, long struct, long x3, long x4) {
        return ((Integer) referenceBridge(x1, struct, x3, x4, 0L, 0L, 0L)).intValue();
    }

    private static int intBridge(long r1, long struct, long x3, long x4, long x5) {
        return ((Integer) referenceBridge(r1, struct, x3, x4, x5, 0L, 0L)).intValue();
    }

    private static int intBridge(long r1, long struct, long x3, long x4, long x5, long x6) {
        return ((Integer) referenceBridge(r1, struct, x3, x4, x5, x6, 0L)).intValue();
    }

    private static int intBridge(long r1, long struct, long x3, long x4, long x5, long x6, long x7) {
        return ((Integer) referenceBridge(r1, struct, x3, x4, x5, x6, x7)).intValue();
    }

    private static long longBridge(long x1, long struct) {
        return ((Long) referenceBridge(x1, struct, 0L, 0L, 0L, 0L, 0L)).longValue();
    }

    private static long longBridge(long x1, long struct, long x3) {
        return ((Long) referenceBridge(x1, struct, x3, 0L, 0L, 0L, 0L)).longValue();
    }

    private static long longBridge(long x1, long struct, long x3, long x4) {
        return ((Long) referenceBridge(x1, struct, x3, x4, 0L, 0L, 0L)).longValue();
    }

    private static long longBridge(long r1, long struct, long x3, long x4, long x5) {
        return ((Long) referenceBridge(r1, struct, x3, x4, x5, 0L, 0L)).longValue();
    }

    private static long longBridge(long r1, long struct, long x3, long x4, long x5, long x6) {
        return ((Long) referenceBridge(r1, struct, x3, x4, x5, x6, 0L)).longValue();
    }

    private static long longBridge(long r1, long struct, long x3, long x4, long x5, long x6, long x7) {
        return ((Long) referenceBridge(r1, struct, x3, x4, x5, x6, x7)).longValue();
    }

    private static float floatBridge(long x1, long struct) {
        return ((Float) referenceBridge(x1, struct, 0L, 0L, 0L, 0L, 0L)).floatValue();
    }

    private static float floatBridge(long x1, long struct, long x3) {
        return ((Float) referenceBridge(x1, struct, x3, 0L, 0L, 0L, 0L)).floatValue();
    }

    private static float floatBridge(long x1, long struct, long x3, long x4) {
        return ((Float) referenceBridge(x1, struct, x3, x4, 0L, 0L, 0L)).floatValue();
    }

    private static float floatBridge(long r1, long struct, long x3, long x4, long x5) {
        return ((Float) referenceBridge(r1, struct, x3, x4, x5, 0L, 0L)).floatValue();
    }

    private static float floatBridge(long r1, long struct, long x3, long x4, long x5, long x6) {
        return ((Float) referenceBridge(r1, struct, x3, x4, x5, x6, 0L)).floatValue();
    }

    private static float floatBridge(long r1, long struct, long x3, long x4, long x5, long x6, long x7) {
        return ((Float) referenceBridge(r1, struct, x3, x4, x5, x6, x7)).floatValue();
    }

    private static double doubleBridge(long x1, long struct) {
        return ((Double) referenceBridge(x1, struct, 0L, 0L, 0L, 0L, 0L)).doubleValue();
    }

    private static double doubleBridge(long x1, long struct, long x3) {
        return ((Double) referenceBridge(x1, struct, x3, 0L, 0L, 0L, 0L)).doubleValue();
    }

    private static double doubleBridge(long x1, long struct, long x3, long x4) {
        return ((Double) referenceBridge(x1, struct, x3, x4, 0L, 0L, 0L)).doubleValue();
    }

    private static double doubleBridge(long r1, long struct, long x3, long x4, long x5) {
        return ((Double) referenceBridge(r1, struct, x3, x4, x5, 0L, 0L)).doubleValue();
    }

    private static double doubleBridge(long r1, long struct, long x3, long x4, long x5, long x6) {
        return ((Double) referenceBridge(r1, struct, x3, x4, x5, x6, 0L)).doubleValue();
    }

    private static double doubleBridge(long r1, long struct, long x3, long x4, long x5, long x6, long x7) {
        return ((Double) referenceBridge(r1, struct, x3, x4, x5, x6, x7)).doubleValue();
    }

    private static Object referenceBridge(long x1, long struct) {
        return referenceBridge(x1, struct, 0L, 0L, 0L, 0L, 0L);
    }

    private static Object referenceBridge(long x1, long struct, long x3) {
        return referenceBridge(x1, struct, x3, 0L, 0L, 0L, 0L);
    }

    private static Object referenceBridge(long x1, long struct, long x3, long x4) {
        return referenceBridge(x1, struct, x3, x4, 0L, 0L, 0L);
    }

    private static Object referenceBridge(long r1, long struct, long x3, long x4, long x5) {
        return referenceBridge(r1, struct, x3, x4, x5, 0L, 0L);
    }

    private static Object referenceBridge(long r1, long struct, long x3, long x4, long x5, long x6) {
        return referenceBridge(r1, struct, x3, x4, x5, x6, 0L);
    }

    private static Object referenceBridge(long x1, long struct, long x3, long x4, long x5, long x6, long x7) {
        Object receiver;
        Logger.i(TAG, "enter bridge function.");
        long self = XposedHelpers.getLongField(Thread.currentThread(), "nativePeer");
        Logger.d(TAG, "java thread native peer:" + Long.toHexString(self));
        Logger.d(TAG, "struct:" + Long.toHexString(struct));
        Logger.d(TAG, "struct:" + Debug.hexdump(EpicNative.get(struct, 24), struct));
        long sp = ByteBuffer.wrap(EpicNative.get(struct, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
        Logger.d(TAG, "stack:" + sp);
        byte[] rr1 = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(x1).array();
        byte[] r2 = EpicNative.get(struct + 8, 8);
        long sourceMethod = ByteBuffer.wrap(EpicNative.get(struct + 16, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
        Logger.d(TAG, "sourceMethod:" + Long.toHexString(sourceMethod));
        Epic.MethodInfo originMethodInfo = Epic.getMethodInfo(sourceMethod);
        Logger.d(TAG, "originMethodInfo :" + originMethodInfo);
        boolean isStatic = originMethodInfo.isStatic;
        int numberOfArgs = originMethodInfo.paramNumber;
        Class<?>[] typeOfArgs = originMethodInfo.paramTypes;
        Object[] arguments = new Object[numberOfArgs];
        if (isStatic) {
            if (numberOfArgs != 0) {
                arguments[0] = wrapArgument(typeOfArgs[0], self, rr1);
                if (numberOfArgs != 1) {
                    arguments[1] = wrapArgument(typeOfArgs[1], self, r2);
                    if (numberOfArgs != 2) {
                        arguments[2] = wrapArgument(typeOfArgs[2], self, x3);
                        if (numberOfArgs != 3) {
                            arguments[3] = wrapArgument(typeOfArgs[3], self, x4);
                            if (numberOfArgs != 4) {
                                arguments[4] = wrapArgument(typeOfArgs[4], self, x5);
                                if (numberOfArgs != 5) {
                                    arguments[5] = wrapArgument(typeOfArgs[5], self, x6);
                                    if (numberOfArgs != 6) {
                                        arguments[6] = wrapArgument(typeOfArgs[6], self, x7);
                                        if (numberOfArgs != 7) {
                                            for (int i = 7; i < numberOfArgs; i++) {
                                                byte[] argsInStack = EpicNative.get(sp + (i * 8) + 8, 8);
                                                arguments[i] = wrapArgument(typeOfArgs[i], self, argsInStack);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            receiver = null;
        } else {
            receiver = EpicNative.getObject(self, x1);
            Logger.i(TAG, "this :" + receiver);
            if (numberOfArgs != 0) {
                arguments[0] = wrapArgument(typeOfArgs[0], self, r2);
                if (numberOfArgs != 1) {
                    arguments[1] = wrapArgument(typeOfArgs[1], self, x3);
                    if (numberOfArgs != 2) {
                        arguments[2] = wrapArgument(typeOfArgs[2], self, x4);
                        if (numberOfArgs != 3) {
                            arguments[3] = wrapArgument(typeOfArgs[3], self, x5);
                            if (numberOfArgs != 4) {
                                arguments[4] = wrapArgument(typeOfArgs[4], self, x6);
                                if (numberOfArgs != 5) {
                                    arguments[5] = wrapArgument(typeOfArgs[5], self, x7);
                                    if (numberOfArgs != 6) {
                                        for (int i2 = 6; i2 < numberOfArgs; i2++) {
                                            byte[] argsInStack2 = EpicNative.get(sp + (i2 * 8) + 16, 8);
                                            arguments[i2] = wrapArgument(typeOfArgs[i2], self, argsInStack2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Logger.i(TAG, "arguments:" + Arrays.toString(arguments));
        Class<?> returnType = originMethodInfo.returnType;
        Object artMethod = originMethodInfo.method;
        Logger.d(TAG, "leave bridge function");
        if (returnType == Void.TYPE) {
            onHookVoid(artMethod, receiver, arguments);
            return 0;
        } else if (returnType == Character.TYPE) {
            return Character.valueOf(onHookChar(artMethod, receiver, arguments));
        } else {
            if (returnType == Byte.TYPE) {
                return Byte.valueOf(onHookByte(artMethod, receiver, arguments));
            }
            if (returnType == Short.TYPE) {
                return Short.valueOf(onHookShort(artMethod, receiver, arguments));
            }
            if (returnType == Integer.TYPE) {
                return Integer.valueOf(onHookInt(artMethod, receiver, arguments));
            }
            if (returnType == Long.TYPE) {
                return Long.valueOf(onHookLong(artMethod, receiver, arguments));
            }
            if (returnType == Float.TYPE) {
                return Float.valueOf(onHookFloat(artMethod, receiver, arguments));
            }
            if (returnType == Double.TYPE) {
                return Double.valueOf(onHookDouble(artMethod, receiver, arguments));
            }
            if (returnType == Boolean.TYPE) {
                return Boolean.valueOf(onHookBoolean(artMethod, receiver, arguments));
            }
            return onHookObject(artMethod, receiver, arguments);
        }
    }

    private static Object wrapArgument(Class<?> type, long self, long value) {
        return wrapArgument(type, self, ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(value).array());
    }

    private static Object wrapArgument(Class<?> type, long self, byte[] value) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(value).order(ByteOrder.LITTLE_ENDIAN);
        if (type.isPrimitive()) {
            if (type == Integer.TYPE) {
                return Integer.valueOf(byteBuffer.getInt());
            }
            if (type == Long.TYPE) {
                return Long.valueOf(byteBuffer.getLong());
            }
            if (type == Float.TYPE) {
                return Float.valueOf(byteBuffer.getFloat());
            }
            if (type == Short.TYPE) {
                return Short.valueOf(byteBuffer.getShort());
            }
            if (type == Byte.TYPE) {
                return Byte.valueOf(byteBuffer.get());
            }
            if (type == Character.TYPE) {
                return Character.valueOf(byteBuffer.getChar());
            }
            if (type == Double.TYPE) {
                return Double.valueOf(byteBuffer.getDouble());
            }
            if (type == Boolean.TYPE) {
                return Boolean.valueOf(byteBuffer.getInt() == 0);
            }
            throw new RuntimeException("unknown type:" + type);
        }
        long address = byteBuffer.getLong();
        Object object = EpicNative.getObject(self, address);
        return object;
    }

    static {
        Class<?>[] primitiveTypes = {Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        for (Class<?> primitiveType : primitiveTypes) {
            bridgeMethodMap.put(primitiveType, primitiveType.getName() + "Bridge");
        }
        bridgeMethodMap.put(Void.TYPE, "voidBridge");
        bridgeMethodMap.put(Object.class, "referenceBridge");
    }

    public static Method getBridgeMethod(Epic.MethodInfo methodInfo) {
        try {
            Class<?> returnType = methodInfo.returnType;
            int paramNumber = methodInfo.isStatic ? methodInfo.paramNumber : methodInfo.paramNumber + 1;
            if (paramNumber <= 2) {
                paramNumber = 2;
            }
            Class<?>[] bridgeParamTypes = new Class[paramNumber];
            for (int i = 0; i < paramNumber; i++) {
                bridgeParamTypes[i] = Long.TYPE;
            }
            String bridgeMethod = bridgeMethodMap.get(returnType.isPrimitive() ? returnType : Object.class);
            Logger.d(TAG, "bridge method:" + bridgeMethod + ", map:" + bridgeMethodMap);
            Method method = Entry64_2.class.getDeclaredMethod(bridgeMethod, bridgeParamTypes);
            method.setAccessible(true);
            return method;
        } catch (Throwable e) {
            throw new RuntimeException("can not found bridge.", e);
        }
    }
}