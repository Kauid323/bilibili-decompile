package shark;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: ProguardMappingReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lshark/ProguardMappingReader;", "", "proguardMappingInputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "parseClassField", "", "line", "", "currentClassName", "proguardMapping", "Lshark/ProguardMapping;", "parseClassMapping", "readProguardMapping", "Companion", "shark-hprof"}, k = 1, mv = {1, 4, 1})
public final class ProguardMappingReader {
    private static final String ARROW_SYMBOL = "->";
    private static final String COLON_SYMBOL = ":";
    public static final Companion Companion = new Companion(null);
    private static final String HASH_SYMBOL = "#";
    private static final String OPENING_PAREN_SYMBOL = "(";
    private static final String SPACE_SYMBOL = " ";
    private final InputStream proguardMappingInputStream;

    public ProguardMappingReader(InputStream proguardMappingInputStream) {
        Intrinsics.checkParameterIsNotNull(proguardMappingInputStream, "proguardMappingInputStream");
        this.proguardMappingInputStream = proguardMappingInputStream;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008a, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, (java.lang.Throwable) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ProguardMapping readProguardMapping() throws FileNotFoundException, IOException, ParseException {
        ProguardMapping proguardMapping = new ProguardMapping();
        InputStreamReader inputStreamReader = new InputStreamReader(this.proguardMappingInputStream, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            BufferedReader bufferedReader2 = bufferedReader;
            String str = null;
            String currentClassName = null;
            while (true) {
                String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                } else {
                    String line = StringsKt.trim(readLine).toString();
                    if (line == null) {
                        break;
                    }
                    if (!(line.length() == 0) && !StringsKt.startsWith$default(line, HASH_SYMBOL, false, 2, (Object) null)) {
                        if (StringsKt.endsWith$default(line, COLON_SYMBOL, false, 2, (Object) null)) {
                            currentClassName = parseClassMapping(line, proguardMapping);
                        } else if (currentClassName != null) {
                            boolean isMethodMapping = StringsKt.contains$default(line, OPENING_PAREN_SYMBOL, false, 2, (Object) null);
                            if (!isMethodMapping) {
                                parseClassField(line, currentClassName, proguardMapping);
                            }
                        }
                    }
                }
            }
        } finally {
        }
    }

    private final String parseClassMapping(String line, ProguardMapping proguardMapping) {
        int colonPosition;
        int arrowPosition = StringsKt.indexOf$default(line, ARROW_SYMBOL, 0, false, 6, (Object) null);
        if (arrowPosition == -1 || (colonPosition = StringsKt.indexOf$default(line, COLON_SYMBOL, arrowPosition + ARROW_SYMBOL.length(), false, 4, (Object) null)) == -1) {
            return null;
        }
        if (line != null) {
            String substring = line.substring(0, arrowPosition);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (substring == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String clearClassName = StringsKt.trim(substring).toString();
            int length = ARROW_SYMBOL.length() + arrowPosition;
            if (line != null) {
                String substring2 = line.substring(length, colonPosition);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obfuscatedClassName = StringsKt.trim(substring2).toString();
                proguardMapping.addMapping(obfuscatedClassName, clearClassName);
                return obfuscatedClassName;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final void parseClassField(String line, String currentClassName, ProguardMapping proguardMapping) {
        int arrowPosition;
        int spacePosition = StringsKt.indexOf$default(line, SPACE_SYMBOL, 0, false, 6, (Object) null);
        if (spacePosition == -1 || (arrowPosition = StringsKt.indexOf$default(line, ARROW_SYMBOL, spacePosition + SPACE_SYMBOL.length(), false, 4, (Object) null)) == -1) {
            return;
        }
        int length = SPACE_SYMBOL.length() + spacePosition;
        if (line == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = line.substring(length, arrowPosition);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String clearFieldName = StringsKt.trim(substring).toString();
        int length2 = ARROW_SYMBOL.length() + arrowPosition;
        if (line == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring2 = line.substring(length2);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
        if (substring2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String obfuscatedFieldName = StringsKt.trim(substring2).toString();
        proguardMapping.addMapping(currentClassName + '.' + obfuscatedFieldName, clearFieldName);
    }

    /* compiled from: ProguardMappingReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lshark/ProguardMappingReader$Companion;", "", "()V", "ARROW_SYMBOL", "", "COLON_SYMBOL", "HASH_SYMBOL", "OPENING_PAREN_SYMBOL", "SPACE_SYMBOL", "shark-hprof"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}