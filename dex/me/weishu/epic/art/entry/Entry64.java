package me.weishu.epic.art.entry;

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

public class Entry64 {
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

    private static void voidBridge(long r1, long self, long struct, long x4, long x5, long x6, long x7) {
        referenceBridge(r1, self, struct, x4, x5, x6, x7);
    }

    private static boolean booleanBridge(long r1, long self, long struct, long x4, long x5, long x6, long x7) {
        return ((Boolean) referenceBridge(r1, self, struct, x4, x5, x6, x7)).booleanValue();
    }

    private static byte byteBridge(long r1, long self, long struct, long x4, long x5, long x6, long x7) {
        return ((Byte) referenceBridge(r1, self, struct, x4, x5, x6, x7)).byteValue();
    }

    private static short shortBridge(long r1, long self, long struct, long x4, long x5, long x6, long x7) {
        return ((Short) referenceBridge(r1, self, struct, x4, x5, x6, x7)).shortValue();
    }

    private static char charBridge(long r1, long self, long struct, long x4, long x5, long x6, long x7) {
        return ((Character) referenceBridge(r1, self, struct, x4, x5, x6, x7)).charValue();
    }

    private static int intBridge(long r1, long self, long struct, long x4, long x5, long x6, long x7) {
        return ((Integer) referenceBridge(r1, self, struct, x4, x5, x6, x7)).intValue();
    }

    private static long longBridge(long r1, long self, long struct, long x4, long x5, long x6, long x7) {
        return ((Long) referenceBridge(r1, self, struct, x4, x5, x6, x7)).longValue();
    }

    private static float floatBridge(long r1, long self, long struct, long x4, long x5, long x6, long x7) {
        return ((Float) referenceBridge(r1, self, struct, x4, x5, x6, x7)).floatValue();
    }

    private static double doubleBridge(long r1, long self, long struct, long x4, long x5, long x6, long x7) {
        return ((Double) referenceBridge(r1, self, struct, x4, x5, x6, x7)).doubleValue();
    }

    private static Object referenceBridge(long x1, long self, long struct, long x4, long x5, long x6, long x7) {
        Epic.MethodInfo originMethodInfo;
        Object receiver;
        Object receiver2;
        Logger.i(TAG, "enter bridge function.");
        Logger.d(TAG, "self:" + Long.toHexString(self));
        long nativePeer = XposedHelpers.getLongField(Thread.currentThread(), "nativePeer");
        Logger.d(TAG, "java thread native peer:" + Long.toHexString(nativePeer));
        Logger.d(TAG, "struct:" + Long.toHexString(struct));
        long sp = ByteBuffer.wrap(EpicNative.get(struct, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
        Logger.d(TAG, "stack:" + sp);
        byte[] rr1 = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(x1).array();
        byte[] r2 = EpicNative.get(struct + 8, 8);
        byte[] r3 = EpicNative.get(struct + 16, 8);
        long sourceMethod = ByteBuffer.wrap(EpicNative.get(24 + struct, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
        Logger.d(TAG, "sourceMethod:" + Long.toHexString(sourceMethod));
        Epic.MethodInfo originMethodInfo2 = Epic.getMethodInfo(sourceMethod);
        Logger.d(TAG, "originMethodInfo :" + originMethodInfo2);
        boolean isStatic = originMethodInfo2.isStatic;
        int numberOfArgs = originMethodInfo2.paramNumber;
        Class<?>[] typeOfArgs = originMethodInfo2.paramTypes;
        Object[] arguments = new Object[numberOfArgs];
        if (isStatic) {
            if (numberOfArgs == 0) {
                originMethodInfo = originMethodInfo2;
            } else {
                arguments[0] = wrapArgument(typeOfArgs[0], nativePeer, rr1);
                if (numberOfArgs == 1) {
                    originMethodInfo = originMethodInfo2;
                } else {
                    arguments[1] = wrapArgument(typeOfArgs[1], nativePeer, r2);
                    if (numberOfArgs == 2) {
                        originMethodInfo = originMethodInfo2;
                    } else {
                        arguments[2] = wrapArgument(typeOfArgs[2], nativePeer, r3);
                        if (numberOfArgs == 3) {
                            originMethodInfo = originMethodInfo2;
                        } else {
                            arguments[3] = wrapArgument(typeOfArgs[3], nativePeer, x4);
                            if (numberOfArgs == 4) {
                                originMethodInfo = originMethodInfo2;
                            } else {
                                arguments[4] = wrapArgument(typeOfArgs[4], nativePeer, x5);
                                if (numberOfArgs == 5) {
                                    originMethodInfo = originMethodInfo2;
                                } else {
                                    originMethodInfo = originMethodInfo2;
                                    arguments[5] = wrapArgument(typeOfArgs[5], nativePeer, x6);
                                    if (numberOfArgs != 6) {
                                        arguments[6] = wrapArgument(typeOfArgs[6], nativePeer, x7);
                                        if (numberOfArgs != 7) {
                                            for (int i = 7; i < numberOfArgs; i++) {
                                                byte[] argsInStack = EpicNative.get(sp + (i * 8) + 8, 8);
                                                arguments[i] = wrapArgument(typeOfArgs[i], nativePeer, argsInStack);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            receiver2 = null;
        } else {
            originMethodInfo = originMethodInfo2;
            Object receiver3 = EpicNative.getObject(nativePeer, x1);
            if (numberOfArgs == 0) {
                receiver = receiver3;
            } else {
                arguments[0] = wrapArgument(typeOfArgs[0], nativePeer, r2);
                if (numberOfArgs == 1) {
                    receiver = receiver3;
                } else {
                    arguments[1] = wrapArgument(typeOfArgs[1], nativePeer, r3);
                    if (numberOfArgs == 2) {
                        receiver = receiver3;
                    } else {
                        arguments[2] = wrapArgument(typeOfArgs[2], nativePeer, x4);
                        if (numberOfArgs == 3) {
                            receiver = receiver3;
                        } else {
                            arguments[3] = wrapArgument(typeOfArgs[3], nativePeer, x5);
                            if (numberOfArgs == 4) {
                                receiver = receiver3;
                            } else {
                                receiver = receiver3;
                                arguments[4] = wrapArgument(typeOfArgs[4], nativePeer, x6);
                                if (numberOfArgs != 5) {
                                    arguments[5] = wrapArgument(typeOfArgs[5], nativePeer, x7);
                                    if (numberOfArgs != 6) {
                                        for (int i2 = 6; i2 < numberOfArgs; i2++) {
                                            byte[] argsInStack2 = EpicNative.get(sp + (i2 * 8) + 16, 8);
                                            arguments[i2] = wrapArgument(typeOfArgs[i2], nativePeer, argsInStack2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            receiver2 = receiver;
        }
        Logger.i(TAG, "arguments:" + Arrays.toString(arguments));
        Epic.MethodInfo originMethodInfo3 = originMethodInfo;
        Class<?> returnType = originMethodInfo3.returnType;
        Object artMethod = originMethodInfo3.method;
        Logger.d(TAG, "leave bridge function");
        if (returnType == Void.TYPE) {
            onHookVoid(artMethod, receiver2, arguments);
            return 0;
        } else if (returnType == Character.TYPE) {
            return Character.valueOf(onHookChar(artMethod, receiver2, arguments));
        } else {
            if (returnType == Byte.TYPE) {
                return Byte.valueOf(onHookByte(artMethod, receiver2, arguments));
            }
            if (returnType == Short.TYPE) {
                return Short.valueOf(onHookShort(artMethod, receiver2, arguments));
            }
            if (returnType == Integer.TYPE) {
                return Integer.valueOf(onHookInt(artMethod, receiver2, arguments));
            }
            if (returnType == Long.TYPE) {
                return Long.valueOf(onHookLong(artMethod, receiver2, arguments));
            }
            if (returnType == Float.TYPE) {
                return Float.valueOf(onHookFloat(artMethod, receiver2, arguments));
            }
            if (returnType == Double.TYPE) {
                return Double.valueOf(onHookDouble(artMethod, receiver2, arguments));
            }
            if (returnType == Boolean.TYPE) {
                return Boolean.valueOf(onHookBoolean(artMethod, receiver2, arguments));
            }
            return onHookObject(artMethod, receiver2, arguments);
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

    public static Method getBridgeMethod(Class<?> returnType) {
        try {
            String bridgeMethod = bridgeMethodMap.get(returnType.isPrimitive() ? returnType : Object.class);
            Logger.d(TAG, "bridge method:" + bridgeMethod + ", map:" + bridgeMethodMap);
            Class cls = Long.TYPE;
            Method method = Entry64.class.getDeclaredMethod(bridgeMethod, cls, cls, cls, cls, cls, cls, cls);
            method.setAccessible(true);
            return method;
        } catch (Throwable e) {
            throw new RuntimeException("error", e);
        }
    }
}