package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class JsonParser {
    private static final Logger logger = Logger.getLogger(JsonParser.class.getName());

    private JsonParser() {
    }

    public static Object parse(String raw) throws IOException {
        JsonReader jr = new JsonReader(new StringReader(raw));
        try {
            return parseRecursive(jr);
        } finally {
            try {
                jr.close();
            } catch (IOException e2) {
                logger.log(Level.WARNING, "Failed to close", (Throwable) e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.grpc.internal.JsonParser$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = new int[JsonToken.values().length];

        static {
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private static Object parseRecursive(JsonReader jr) throws IOException {
        Preconditions.checkState(jr.hasNext(), "unexpected end of JSON");
        switch (AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jr.peek().ordinal()]) {
            case 1:
                return parseJsonArray(jr);
            case 2:
                return parseJsonObject(jr);
            case 3:
                return jr.nextString();
            case 4:
                return Double.valueOf(jr.nextDouble());
            case 5:
                return Boolean.valueOf(jr.nextBoolean());
            case 6:
                return parseJsonNull(jr);
            default:
                throw new IllegalStateException("Bad token: " + jr.getPath());
        }
    }

    private static Map<String, ?> parseJsonObject(JsonReader jr) throws IOException {
        jr.beginObject();
        Map<String, Object> obj = new LinkedHashMap<>();
        while (jr.hasNext()) {
            String name = jr.nextName();
            Object value = parseRecursive(jr);
            obj.put(name, value);
        }
        Preconditions.checkState(jr.peek() == JsonToken.END_OBJECT, "Bad token: " + jr.getPath());
        jr.endObject();
        return Collections.unmodifiableMap(obj);
    }

    private static List<?> parseJsonArray(JsonReader jr) throws IOException {
        jr.beginArray();
        List<Object> array = new ArrayList<>();
        while (jr.hasNext()) {
            Object value = parseRecursive(jr);
            array.add(value);
        }
        Preconditions.checkState(jr.peek() == JsonToken.END_ARRAY, "Bad token: " + jr.getPath());
        jr.endArray();
        return Collections.unmodifiableList(array);
    }

    private static Void parseJsonNull(JsonReader jr) throws IOException {
        jr.nextNull();
        return null;
    }
}