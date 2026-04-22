package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: JsonTreeReader.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\u0082\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J!\u0010\u000f\u001a\u00020\f*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "isLenient", "", "stackDepth", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readDeepRecursive", "readObject", "readObjectImpl", "Lkotlinx/serialization/json/JsonObject;", "reader", "Lkotlin/Function0;", "readValue", "Lkotlinx/serialization/json/JsonPrimitive;", "isString", "Lkotlin/DeepRecursiveScope;", "", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JsonTreeReader {
    private final boolean isLenient;
    private final AbstractJsonLexer lexer;
    private int stackDepth;

    public JsonTreeReader(JsonConfiguration configuration, AbstractJsonLexer lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.lexer = lexer;
        this.isLenient = configuration.isLenient();
    }

    private final JsonElement readObject() {
        byte lastToken$iv = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap result$iv = new LinkedHashMap();
        while (true) {
            if (!this.lexer.canConsumeValue()) {
                break;
            }
            String key$iv = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            JsonElement element$iv = read();
            result$iv.put(key$iv, element$iv);
            lastToken$iv = this.lexer.consumeNextToken();
            if (lastToken$iv != 4) {
                if (lastToken$iv != 7) {
                    AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (lastToken$iv == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (lastToken$iv == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return new JsonObject(result$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00de  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a6 -> B:26:0x00b0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readObject(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Continuation<? super JsonElement> continuation) {
        JsonTreeReader$readObject$2 jsonTreeReader$readObject$2;
        byte lastToken$iv;
        String key$iv;
        Object $result;
        DeepRecursiveScope $this$readObject;
        LinkedHashMap result$iv;
        JsonTreeReader this_$iv;
        boolean z;
        Object obj;
        if (continuation instanceof JsonTreeReader$readObject$2) {
            JsonTreeReader$readObject$2 jsonTreeReader$readObject$22 = (JsonTreeReader$readObject$2) continuation;
            if ((jsonTreeReader$readObject$22.label & IntCompanionObject.MIN_VALUE) != 0) {
                jsonTreeReader$readObject$22.label -= IntCompanionObject.MIN_VALUE;
                jsonTreeReader$readObject$2 = jsonTreeReader$readObject$22;
                Object $result2 = jsonTreeReader$readObject$2.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (jsonTreeReader$readObject$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        lastToken$iv = this.lexer.consumeNextToken((byte) 6);
                        if (this.lexer.peekNextToken() == 4) {
                            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
                            throw new KotlinNothingValueException();
                        }
                        LinkedHashMap result$iv2 = new LinkedHashMap();
                        DeepRecursiveScope $this$readObject2 = deepRecursiveScope;
                        JsonTreeReader this_$iv2 = this;
                        boolean z2 = false;
                        if (this_$iv2.lexer.canConsumeValue()) {
                            key$iv = this_$iv2.isLenient ? this_$iv2.lexer.consumeStringLenient() : this_$iv2.lexer.consumeString();
                            this_$iv2.lexer.consumeNextToken((byte) 5);
                            Unit unit = Unit.INSTANCE;
                            jsonTreeReader$readObject$2.L$0 = $this$readObject2;
                            jsonTreeReader$readObject$2.L$1 = this_$iv2;
                            jsonTreeReader$readObject$2.L$2 = result$iv2;
                            jsonTreeReader$readObject$2.L$3 = key$iv;
                            jsonTreeReader$readObject$2.label = 1;
                            Object callRecursive = $this$readObject2.callRecursive(unit, jsonTreeReader$readObject$2);
                            if (callRecursive == $result3) {
                                return $result3;
                            }
                            Object obj2 = $result3;
                            $result = $result2;
                            $result2 = callRecursive;
                            $this$readObject = $this$readObject2;
                            result$iv = result$iv2;
                            this_$iv = this_$iv2;
                            z = z2;
                            obj = obj2;
                            JsonElement element$iv = (JsonElement) $result2;
                            result$iv.put(key$iv, element$iv);
                            lastToken$iv = this_$iv.lexer.consumeNextToken();
                            if (lastToken$iv != 4) {
                                $result2 = $result;
                                $result3 = obj;
                                z2 = z;
                                this_$iv2 = this_$iv;
                                result$iv2 = result$iv;
                                $this$readObject2 = $this$readObject;
                                if (this_$iv2.lexer.canConsumeValue()) {
                                }
                            } else if (lastToken$iv != 7) {
                                AbstractJsonLexer.fail$default(this_$iv.lexer, "Expected end of the object or comma", 0, null, 6, null);
                                throw new KotlinNothingValueException();
                            } else {
                                this_$iv2 = this_$iv;
                                result$iv2 = result$iv;
                            }
                        }
                        if (lastToken$iv == 6) {
                            this_$iv2.lexer.consumeNextToken((byte) 7);
                        } else if (lastToken$iv == 4) {
                            AbstractJsonLexer.fail$default(this_$iv2.lexer, "Unexpected trailing comma", 0, null, 6, null);
                            throw new KotlinNothingValueException();
                        }
                        return new JsonObject(result$iv2);
                    case 1:
                        key$iv = (String) jsonTreeReader$readObject$2.L$3;
                        LinkedHashMap result$iv3 = (LinkedHashMap) jsonTreeReader$readObject$2.L$2;
                        this_$iv = (JsonTreeReader) jsonTreeReader$readObject$2.L$1;
                        DeepRecursiveScope $this$readObject3 = (DeepRecursiveScope) jsonTreeReader$readObject$2.L$0;
                        ResultKt.throwOnFailure($result2);
                        $this$readObject = $this$readObject3;
                        result$iv = result$iv3;
                        z = false;
                        obj = $result3;
                        $result = $result2;
                        JsonElement element$iv2 = (JsonElement) $result2;
                        result$iv.put(key$iv, element$iv2);
                        lastToken$iv = this_$iv.lexer.consumeNextToken();
                        if (lastToken$iv != 4) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        jsonTreeReader$readObject$2 = new JsonTreeReader$readObject$2(this, continuation);
        Object $result22 = jsonTreeReader$readObject$2.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (jsonTreeReader$readObject$2.label) {
        }
    }

    private final JsonObject readObjectImpl(Function0<? extends JsonElement> function0) {
        byte lastToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap result = new LinkedHashMap();
        while (true) {
            if (!this.lexer.canConsumeValue()) {
                break;
            }
            String key = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            JsonElement element = function0.invoke();
            result.put(key, element);
            lastToken = this.lexer.consumeNextToken();
            if (lastToken != 4) {
                if (lastToken != 7) {
                    AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (lastToken == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (lastToken == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return new JsonObject(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement readArray() {
        byte lastToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList result = new ArrayList();
        while (this.lexer.canConsumeValue()) {
            JsonElement element = read();
            result.add(element);
            lastToken = this.lexer.consumeNextToken();
            if (lastToken != 4) {
                AbstractJsonLexer $this$iv = this.lexer;
                boolean condition$iv = lastToken == 9;
                int position$iv = $this$iv.currentPosition;
                if (!condition$iv) {
                    AbstractJsonLexer.fail$default($this$iv, "Expected end of the array or comma", position$iv, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (lastToken == 8) {
            this.lexer.consumeNextToken((byte) 9);
        } else if (lastToken == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return new JsonArray(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive readValue(boolean isString) {
        String string;
        if (this.isLenient || !isString) {
            string = this.lexer.consumeStringLenient();
        } else {
            string = this.lexer.consumeString();
        }
        return (isString || !Intrinsics.areEqual(string, AbstractJsonLexerKt.NULL)) ? new JsonLiteral(string, isString, null, 4, null) : JsonNull.INSTANCE;
    }

    public final JsonElement read() {
        JsonElement readObject;
        byte token = this.lexer.peekNextToken();
        if (token == 1) {
            return readValue(true);
        }
        if (token == 0) {
            return readValue(false);
        }
        if (token == 6) {
            this.stackDepth++;
            if (this.stackDepth == 200) {
                readObject = readDeepRecursive();
            } else {
                readObject = readObject();
            }
            this.stackDepth--;
            return readObject;
        } else if (token == 8) {
            return readArray();
        } else {
            AbstractJsonLexer.fail$default(this.lexer, "Cannot begin reading element, unexpected token: " + ((int) token), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    private final JsonElement readDeepRecursive() {
        return (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.INSTANCE);
    }
}