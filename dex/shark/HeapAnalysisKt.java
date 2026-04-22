package shark;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeapAnalysis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\b\u0010\u0004\u001a\u00020\u0001H\u0002¨\u0006\u0005"}, d2 = {"androidManufacturer", "", "androidSdkInt", "", "leakCanaryVersion", "shark"}, k = 2, mv = {1, 4, 1})
public final class HeapAnalysisKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int androidSdkInt() {
        try {
            Class versionClass = Class.forName("android.os.Build$VERSION");
            Field sdkIntField = versionClass.getDeclaredField("SDK_INT");
            Object obj = sdkIntField.get(null);
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String androidManufacturer() {
        try {
            Class buildClass = Class.forName("android.os.Build");
            Field manufacturerField = buildClass.getDeclaredField("MANUFACTURER");
            Object obj = manufacturerField.get(null);
            if (obj != null) {
                return (String) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e) {
            return "Unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String leakCanaryVersion() {
        try {
            Class versionHolderClass = Class.forName("leakcanary.internal.InternalLeakCanary");
            Field versionField = versionHolderClass.getDeclaredField("version");
            Intrinsics.checkExpressionValueIsNotNull(versionField, "versionField");
            versionField.setAccessible(true);
            Object obj = versionField.get(null);
            if (obj != null) {
                return (String) obj;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e) {
            return "Unknown";
        }
    }
}