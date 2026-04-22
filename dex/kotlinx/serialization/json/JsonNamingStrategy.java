package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: JsonNamingStrategy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bç\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy;", "", "serialNameForJson", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementIndex", "", "serialName", "Builtins", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
public interface JsonNamingStrategy {
    public static final Builtins Builtins = Builtins.$$INSTANCE;

    String serialNameForJson(SerialDescriptor serialDescriptor, int i, String str);

    /* compiled from: JsonNamingStrategy.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy$Builtins;", "", "()V", "SnakeCase", "Lkotlinx/serialization/json/JsonNamingStrategy;", "getSnakeCase$annotations", "getSnakeCase", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ExperimentalSerializationApi
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Builtins {
        static final /* synthetic */ Builtins $$INSTANCE = new Builtins();
        private static final JsonNamingStrategy SnakeCase = new JsonNamingStrategy() { // from class: kotlinx.serialization.json.JsonNamingStrategy$Builtins$SnakeCase$1
            @Override // kotlinx.serialization.json.JsonNamingStrategy
            public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(serialName, "serialName");
                StringBuilder $this$serialNameForJson_u24lambda_u241 = new StringBuilder(serialName.length() * 2);
                Character ch = null;
                int previousUpperCharsCount = 0;
                String $this$forEach$iv = serialName;
                for (int i = 0; i < $this$forEach$iv.length(); i++) {
                    char element$iv = $this$forEach$iv.charAt(i);
                    if (Character.isUpperCase(element$iv)) {
                        if (previousUpperCharsCount == 0) {
                            if (($this$serialNameForJson_u24lambda_u241.length() > 0) && StringsKt.last($this$serialNameForJson_u24lambda_u241) != '_') {
                                $this$serialNameForJson_u24lambda_u241.append('_');
                            }
                        }
                        if (ch != null) {
                            char p0 = ch.charValue();
                            $this$serialNameForJson_u24lambda_u241.append(p0);
                        }
                        previousUpperCharsCount++;
                        ch = Character.valueOf(Character.toLowerCase(element$iv));
                    } else {
                        if (ch != null) {
                            if (previousUpperCharsCount > 1 && Character.isLetter(element$iv)) {
                                $this$serialNameForJson_u24lambda_u241.append('_');
                            }
                            $this$serialNameForJson_u24lambda_u241.append(ch);
                            previousUpperCharsCount = 0;
                            ch = null;
                        }
                        $this$serialNameForJson_u24lambda_u241.append(element$iv);
                    }
                }
                if (ch != null) {
                    $this$serialNameForJson_u24lambda_u241.append(ch);
                }
                String sb = $this$serialNameForJson_u24lambda_u241.toString();
                Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder(capacity).…builderAction).toString()");
                return sb;
            }

            public String toString() {
                return "kotlinx.serialization.json.JsonNamingStrategy.SnakeCase";
            }
        };

        @ExperimentalSerializationApi
        public static /* synthetic */ void getSnakeCase$annotations() {
        }

        private Builtins() {
        }

        public final JsonNamingStrategy getSnakeCase() {
            return SnakeCase;
        }
    }
}