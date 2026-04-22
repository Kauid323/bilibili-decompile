package c.t.m.g;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import java.io.Serializable;

/* compiled from: TML */
public class y2 {
    public static void a(Bundle bundle, String str, Object obj, Class<?> cls) {
        if (d4.a(bundle, obj)) {
            return;
        }
        synchronized (bundle) {
            if (cls == Boolean.class) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (cls == Byte.class) {
                bundle.putByte(str, ((Byte) obj).byteValue());
            } else if (cls == Short.class) {
                bundle.putShort(str, ((Short) obj).shortValue());
            } else if (cls == Character.class) {
                bundle.putChar(str, ((Character) obj).charValue());
            } else if (cls == Integer.class) {
                bundle.putInt(str, ((Integer) obj).intValue());
            } else if (cls == Long.class) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (cls == Float.class) {
                bundle.putFloat(str, ((Float) obj).floatValue());
            } else if (cls == Double.class) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (cls == String.class) {
                bundle.putString(str, (String) obj);
            } else if (cls == CharSequence.class) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (cls == Serializable.class) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (cls == Parcelable.class) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (cls == PersistableBundle.class) {
                bundle.putAll((PersistableBundle) obj);
            } else {
                a("cannot support class " + cls.getName());
                throw null;
            }
        }
    }

    public static void a(String str) {
        throw new IllegalArgumentException(str);
    }
}