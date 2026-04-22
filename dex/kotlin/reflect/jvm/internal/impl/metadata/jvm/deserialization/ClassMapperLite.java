package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;

/* compiled from: ClassMapperLite.kt */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f11kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
    private static final Map<String, String> map;

    private ClassMapperLite() {
    }

    static {
        Map $this$map_u24lambda_u240 = new LinkedHashMap();
        List primitives = CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, primitives.size() - 1, 2);
        if (0 <= progressionLastElement) {
            while (true) {
                $this$map_u24lambda_u240.put(f11kotlin + '/' + ((String) primitives.get(i)), primitives.get(i + 1));
                $this$map_u24lambda_u240.put(f11kotlin + '/' + ((String) primitives.get(i)) + "Array", AbstractJsonLexerKt.BEGIN_LIST + ((String) primitives.get(i + 1)));
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        $this$map_u24lambda_u240.put(f11kotlin + "/Unit", "V");
        map$lambda$0$add($this$map_u24lambda_u240, "Any", "java/lang/Object");
        map$lambda$0$add($this$map_u24lambda_u240, "Nothing", "java/lang/Void");
        map$lambda$0$add($this$map_u24lambda_u240, "Annotation", "java/lang/annotation/Annotation");
        for (String klass : CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            map$lambda$0$add($this$map_u24lambda_u240, klass, "java/lang/" + klass);
        }
        for (String klass2 : CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            map$lambda$0$add($this$map_u24lambda_u240, "collections/" + klass2, "java/util/" + klass2);
            map$lambda$0$add($this$map_u24lambda_u240, "collections/Mutable" + klass2, "java/util/" + klass2);
        }
        map$lambda$0$add($this$map_u24lambda_u240, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add($this$map_u24lambda_u240, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add($this$map_u24lambda_u240, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add($this$map_u24lambda_u240, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i2 = 0; i2 < 23; i2++) {
            map$lambda$0$add($this$map_u24lambda_u240, "Function" + i2, f11kotlin + "/jvm/functions/Function" + i2);
            map$lambda$0$add($this$map_u24lambda_u240, "reflect/KFunction" + i2, f11kotlin + "/reflect/KFunction");
        }
        for (String klass3 : CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            map$lambda$0$add($this$map_u24lambda_u240, klass3 + ".Companion", f11kotlin + "/jvm/internal/" + klass3 + "CompanionObject");
        }
        map = $this$map_u24lambda_u240;
    }

    private static final void map$lambda$0$add(Map<String, String> map2, String kotlinSimpleName, String javaInternalName) {
        map2.put(f11kotlin + '/' + kotlinSimpleName, 'L' + javaInternalName + ';');
    }

    @JvmStatic
    public static final String mapClass(String classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        String str = map.get(classId);
        return str == null ? 'L' + StringsKt.replace$default(classId, (char) FilenameUtils.EXTENSION_SEPARATOR, (char) Typography.dollar, false, 4, (Object) null) + ';' : str;
    }
}