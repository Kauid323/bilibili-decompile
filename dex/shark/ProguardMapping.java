package shark;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProguardMapping.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lshark/ProguardMapping;", "", "()V", "obfuscatedToClearNamesMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "addMapping", "", "obfuscatedName", "clearName", "deobfuscateClassName", "obfuscatedClassName", "deobfuscateFieldName", "obfuscatedClass", "obfuscatedField", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class ProguardMapping {
    private final LinkedHashMap<String, String> obfuscatedToClearNamesMap = new LinkedHashMap<>();

    public final String deobfuscateClassName(String obfuscatedClassName) {
        Intrinsics.checkParameterIsNotNull(obfuscatedClassName, "obfuscatedClassName");
        String str = this.obfuscatedToClearNamesMap.get(obfuscatedClassName);
        return str != null ? str : obfuscatedClassName;
    }

    public final String deobfuscateFieldName(String obfuscatedClass, String obfuscatedField) {
        Intrinsics.checkParameterIsNotNull(obfuscatedClass, "obfuscatedClass");
        Intrinsics.checkParameterIsNotNull(obfuscatedField, "obfuscatedField");
        String str = this.obfuscatedToClearNamesMap.get(obfuscatedClass + '.' + obfuscatedField);
        return str != null ? str : obfuscatedField;
    }

    public final void addMapping(String obfuscatedName, String clearName) {
        Intrinsics.checkParameterIsNotNull(obfuscatedName, "obfuscatedName");
        Intrinsics.checkParameterIsNotNull(clearName, "clearName");
        this.obfuscatedToClearNamesMap.put(obfuscatedName, clearName);
    }
}