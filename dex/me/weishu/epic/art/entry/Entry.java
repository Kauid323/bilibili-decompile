package me.weishu.epic.art.entry;

import android.os.Build;
import android.util.Pair;
import com.taobao.android.dexposed.utility.Debug;
import com.taobao.android.dexposed.utility.Logger;
import de.robv.android.xposed.DexposedBridge;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import me.weishu.epic.art.Epic;
import me.weishu.epic.art.EpicNative;

public class Entry {
    private static final String TAG = "Entry";
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private static Map<Class<?>, String> bridgeMethodMap = new HashMap();

    static {
        Class<?>[] primitiveTypes = {Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        for (Class<?> primitiveType : primitiveTypes) {
            bridgeMethodMap.put(primitiveType, primitiveType.getName() + "Bridge");
        }
        bridgeMethodMap.put(Object.class, "referenceBridge");
        bridgeMethodMap.put(Void.TYPE, "voidBridge");
    }

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

    private static void voidBridge(int r1, int self, int struct) {
        referenceBridge(r1, self, struct);
    }

    private static boolean booleanBridge(int r1, int self, int struct) {
        return ((Boolean) referenceBridge(r1, self, struct)).booleanValue();
    }

    private static byte byteBridge(int r1, int self, int struct) {
        return ((Byte) referenceBridge(r1, self, struct)).byteValue();
    }

    private static short shortBridge(int r1, int self, int struct) {
        return ((Short) referenceBridge(r1, self, struct)).shortValue();
    }

    private static char charBridge(int r1, int self, int struct) {
        return ((Character) referenceBridge(r1, self, struct)).charValue();
    }

    private static int intBridge(int r1, int self, int struct) {
        return ((Integer) referenceBridge(r1, self, struct)).intValue();
    }

    private static long longBridge(int r1, int self, int struct) {
        return ((Long) referenceBridge(r1, self, struct)).longValue();
    }

    private static float floatBridge(int r1, int self, int struct) {
        return ((Float) referenceBridge(r1, self, struct)).floatValue();
    }

    private static double doubleBridge(int r1, int self, int struct) {
        return ((Double) referenceBridge(r1, self, struct)).doubleValue();
    }

    private static Object referenceBridge(int r1, int self, int struct) {
        Logger.i(TAG, "enter bridge function.");
        Logger.i(TAG, "struct:" + Long.toHexString(struct));
        int sp = ByteBuffer.wrap(EpicNative.get(struct, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
        byte[] rr1 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(r1).array();
        byte[] r2 = EpicNative.get(struct + 4, 4);
        byte[] r3 = EpicNative.get(struct + 8, 4);
        Logger.d(TAG, "r1:" + Debug.hexdump(rr1, 0L));
        Logger.d(TAG, "r2:" + Debug.hexdump(r2, 0L));
        Logger.d(TAG, "r3:" + Debug.hexdump(r3, 0L));
        byte[] sourceAddr = EpicNative.get(struct + 12, 4);
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[8]);
        byteBuffer.put(sourceAddr);
        byteBuffer.put(new byte[]{0, 0, 0, 0});
        byteBuffer.flip();
        long sourceMethod = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong();
        Logger.i(TAG, "sourceMethod:" + Long.toHexString(sourceMethod));
        Epic.MethodInfo originMethodInfo = Epic.getMethodInfo(sourceMethod);
        Logger.i(TAG, "originMethodInfo :" + originMethodInfo);
        Pair<Object, Object[]> constructArguments = constructArguments(originMethodInfo, self, rr1, r2, r3, sp);
        Object receiver = constructArguments.first;
        Object[] arguments = (Object[]) constructArguments.second;
        Logger.i(TAG, "arguments:" + Arrays.toString(arguments));
        Class<?> returnType = originMethodInfo.returnType;
        Object artMethod = originMethodInfo.method;
        Logger.i(TAG, "leave bridge function");
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<Object, Object[]> constructArguments(Epic.MethodInfo originMethodInfo, int self, byte[] r1, byte[] r2, byte[] r3, int sp) {
        int numberOfArgs;
        Class<?>[] typeOfArgs;
        boolean isStatic;
        boolean isStatic2 = originMethodInfo.isStatic;
        if (!isStatic2) {
            numberOfArgs = originMethodInfo.paramNumber + 1;
            typeOfArgs = new Class[numberOfArgs];
            typeOfArgs[0] = Object.class;
            System.arraycopy(originMethodInfo.paramTypes, 0, typeOfArgs, 1, originMethodInfo.paramTypes.length);
        } else {
            numberOfArgs = originMethodInfo.paramNumber;
            typeOfArgs = originMethodInfo.paramTypes;
        }
        Object[] arguments = new Object[numberOfArgs];
        int currentStackPosition = 4;
        int[] argStartPos = new int[numberOfArgs];
        for (int i = 0; i < numberOfArgs; i++) {
            int typeLength = getTypeLength(typeOfArgs[i]);
            argStartPos[i] = currentStackPosition;
            currentStackPosition += typeLength;
        }
        int i2 = currentStackPosition;
        byte[] argBytes = new byte[i2];
        if (i2 > 4) {
            boolean align = numberOfArgs > 0 && getTypeLength(typeOfArgs[0]) == 8;
            if (align) {
                System.arraycopy(r2, 0, argBytes, 4, 4);
                System.arraycopy(r3, 0, argBytes, 8, 4);
                if (i2 > 12) {
                    System.arraycopy(EpicNative.get(sp + 12, 4), 0, argBytes, 12, 4);
                    if (i2 > 16) {
                        byte[] argInStack = EpicNative.get(sp + 16, i2 - 16);
                        System.arraycopy(argInStack, 0, argBytes, 16, i2 - 16);
                    }
                }
            } else {
                System.arraycopy(r1, 0, argBytes, 4, 4);
                if (i2 > 8) {
                    System.arraycopy(r2, 0, argBytes, 8, 4);
                    if (i2 > 12) {
                        System.arraycopy(r3, 0, argBytes, 12, 4);
                        if (i2 > 16) {
                        }
                    }
                }
            }
        }
        if (Build.VERSION.SDK_INT != 23) {
            isStatic = isStatic2;
        } else if (i2 <= 12) {
            isStatic = isStatic2;
        } else if (i2 <= 16) {
            if (getTypeLength(typeOfArgs[0]) != 8) {
                isStatic = isStatic2;
            } else {
                System.arraycopy(EpicNative.get(sp + 44, 4), 0, argBytes, 12, 4);
                isStatic = isStatic2;
            }
        } else {
            boolean isR3Grabbed = true;
            if (numberOfArgs >= 2) {
                int arg1TypeLength = getTypeLength(typeOfArgs[0]);
                int arg2TypeLength = getTypeLength(typeOfArgs[1]);
                if (arg1TypeLength == 4 && arg2TypeLength == 8) {
                    isR3Grabbed = false;
                }
                if (numberOfArgs == 2 && arg1TypeLength == 8 && arg2TypeLength == 8) {
                    System.arraycopy(EpicNative.get(sp + 44, 4), 0, argBytes, 12, 4);
                    isR3Grabbed = false;
                }
            }
            if (numberOfArgs >= 3) {
                int arg1TypeLength2 = getTypeLength(typeOfArgs[0]);
                int arg2TypeLength2 = getTypeLength(typeOfArgs[1]);
                int arg3TypeLength = getTypeLength(typeOfArgs[2]);
                if (arg1TypeLength2 == 4 && arg2TypeLength2 == 4 && arg3TypeLength == 4) {
                    isR3Grabbed = false;
                }
                if (numberOfArgs == 3 && arg1TypeLength2 == 8 && arg2TypeLength2 == 4 && arg3TypeLength == 8) {
                    System.arraycopy(EpicNative.get(sp + 52, 4), 0, argBytes, 12, 4);
                    isR3Grabbed = false;
                }
            }
            if (!isR3Grabbed) {
                isStatic = isStatic2;
            } else {
                byte[] otherStoreInStack = Arrays.copyOfRange(argBytes, 16, argBytes.length);
                int otherStoreInStackLength = otherStoreInStack.length;
                int searchRegion = 0;
                int i3 = otherStoreInStackLength + 16;
                while (true) {
                    boolean isR3Grabbed2 = isR3Grabbed;
                    byte[] bytes = EpicNative.get(sp + i3, otherStoreInStackLength);
                    searchRegion += otherStoreInStackLength;
                    if (Arrays.equals(bytes, otherStoreInStack)) {
                        int originR3Index = (sp + i3) - 4;
                        isStatic = isStatic2;
                        byte[] originR3 = EpicNative.get(originR3Index, 4);
                        Logger.d(TAG, "found other arguments in stack, index:" + i3 + ", origin r3:" + Arrays.toString(originR3));
                        System.arraycopy(originR3, 0, argBytes, 12, 4);
                        break;
                    }
                    byte[] otherStoreInStack2 = otherStoreInStack;
                    int otherStoreInStackLength2 = otherStoreInStackLength;
                    boolean isStatic3 = isStatic2;
                    if (searchRegion <= 1024) {
                        i3 += 4;
                        isR3Grabbed = isR3Grabbed2;
                        otherStoreInStack = otherStoreInStack2;
                        isStatic2 = isStatic3;
                        otherStoreInStackLength = otherStoreInStackLength2;
                    } else {
                        throw new RuntimeException("can not found the modify r3 register!!!");
                    }
                }
            }
        }
        Logger.d(TAG, "argBytes: " + Debug.hexdump(argBytes, 0L));
        for (int i4 = 0; i4 < numberOfArgs; i4++) {
            Class<?> typeOfArg = typeOfArgs[i4];
            int startPos = argStartPos[i4];
            int typeLength2 = getTypeLength(typeOfArg);
            byte[] argWithBytes = Arrays.copyOfRange(argBytes, startPos, startPos + typeLength2);
            arguments[i4] = wrapArgument(typeOfArg, self, argWithBytes);
        }
        Object thiz = null;
        Object[] parameters = EMPTY_OBJECT_ARRAY;
        if (isStatic) {
            parameters = arguments;
        } else {
            thiz = arguments[0];
            int argumentLength = arguments.length;
            if (argumentLength > 1) {
                parameters = Arrays.copyOfRange(arguments, 1, argumentLength);
            }
        }
        return Pair.create(thiz, parameters);
    }

    private static Object wrapArgument(Class<?> type, int self, byte[] value) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(value).order(ByteOrder.LITTLE_ENDIAN);
        Logger.d(TAG, "wrapArgument: type:" + type);
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
                return Boolean.valueOf(byteBuffer.getInt() != 0);
            }
            throw new RuntimeException("unknown type:" + type);
        }
        int address = byteBuffer.getInt();
        Object object = EpicNative.getObject(self, address);
        return object;
    }

    public static Method getBridgeMethod(Class<?> returnType) {
        try {
            String bridgeMethod = bridgeMethodMap.get(returnType.isPrimitive() ? returnType : Object.class);
            Logger.i(TAG, "bridge method:" + bridgeMethod + ", map:" + bridgeMethodMap);
            Class cls = Integer.TYPE;
            Method method = Entry.class.getDeclaredMethod(bridgeMethod, cls, cls, cls);
            method.setAccessible(true);
            return method;
        } catch (Throwable e) {
            throw new RuntimeException("error", e);
        }
    }

    private static int getTypeLength(Class<?> clazz) {
        if (clazz == Long.TYPE || clazz == Double.TYPE) {
            return 8;
        }
        return 4;
    }
}