package retrofit2;

import j$.util.Objects;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
public abstract class ParameterHandler<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException;

    ParameterHandler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
            @Override // retrofit2.ParameterHandler
            /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                apply(requestBuilder, (Iterable) ((Iterable) obj));
            }

            void apply(RequestBuilder builder, @Nullable Iterable<T> values) throws IOException {
                if (values == null) {
                    return;
                }
                for (T value : values) {
                    ParameterHandler.this.apply(builder, value);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // retrofit2.ParameterHandler
            void apply(RequestBuilder builder, @Nullable Object values) throws IOException {
                if (values == null) {
                    return;
                }
                int size = Array.getLength(values);
                for (int i = 0; i < size; i++) {
                    ParameterHandler.this.apply(builder, Array.get(values, i));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;
        private final int p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RelativeUrl(Method method, int p) {
            this.method = method;
            this.p = p;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder builder, @Nullable Object value) {
            if (value == null) {
                throw Utils.parameterError(this.method, this.p, "@Url parameter is null.", new Object[0]);
            }
            builder.setRelativeUrl(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Header(String name, Converter<T, String> valueConverter) {
            this.name = (String) Objects.requireNonNull(name, "name == null");
            this.valueConverter = valueConverter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder builder, @Nullable T value) throws IOException {
            String headerValue;
            if (value == null || (headerValue = this.valueConverter.convert(value)) == null) {
                return;
            }
            builder.addHeader(this.name, headerValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;
        private final int p;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Path(Method method, int p, String name, Converter<T, String> valueConverter, boolean encoded) {
            this.method = method;
            this.p = p;
            this.name = (String) Objects.requireNonNull(name, "name == null");
            this.valueConverter = valueConverter;
            this.encoded = encoded;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder builder, @Nullable T value) throws IOException {
            if (value == null) {
                throw Utils.parameterError(this.method, this.p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
            }
            builder.addPathParam(this.name, this.valueConverter.convert(value), this.encoded);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Query(String name, Converter<T, String> valueConverter, boolean encoded) {
            this.name = (String) Objects.requireNonNull(name, "name == null");
            this.valueConverter = valueConverter;
            this.encoded = encoded;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder builder, @Nullable T value) throws IOException {
            String queryValue;
            if (value == null || (queryValue = this.valueConverter.convert(value)) == null) {
                return;
            }
            builder.addQueryParam(this.name, queryValue, this.encoded);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public QueryName(Converter<T, String> nameConverter, boolean encoded) {
            this.nameConverter = nameConverter;
            this.encoded = encoded;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder builder, @Nullable T value) throws IOException {
            if (value == null) {
                return;
            }
            builder.addQueryParam(this.nameConverter.convert(value), null, this.encoded);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        @Override // retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public QueryMap(Method method, int p, Converter<T, String> valueConverter, boolean encoded) {
            this.method = method;
            this.p = p;
            this.valueConverter = valueConverter;
            this.encoded = encoded;
        }

        void apply(RequestBuilder builder, @Nullable Map<String, T> value) throws IOException {
            if (value == null) {
                throw Utils.parameterError(this.method, this.p, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : value.entrySet()) {
                String entryKey = entry.getKey();
                if (entryKey == null) {
                    throw Utils.parameterError(this.method, this.p, "Query map contained null key.", new Object[0]);
                }
                T entryValue = entry.getValue();
                if (entryValue == null) {
                    throw Utils.parameterError(this.method, this.p, "Query map contained null value for key '" + entryKey + "'.", new Object[0]);
                }
                String convertedEntryValue = this.valueConverter.convert(entryValue);
                if (convertedEntryValue == null) {
                    throw Utils.parameterError(this.method, this.p, "Query map value '" + entryValue + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + entryKey + "'.", new Object[0]);
                }
                builder.addQueryParam(entryKey, convertedEntryValue, this.encoded);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        @Override // retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderMap(Method method, int p, Converter<T, String> valueConverter) {
            this.method = method;
            this.p = p;
            this.valueConverter = valueConverter;
        }

        void apply(RequestBuilder builder, @Nullable Map<String, T> value) throws IOException {
            if (value == null) {
                throw Utils.parameterError(this.method, this.p, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : value.entrySet()) {
                String headerName = entry.getKey();
                if (headerName == null) {
                    throw Utils.parameterError(this.method, this.p, "Header map contained null key.", new Object[0]);
                }
                T headerValue = entry.getValue();
                if (headerValue == null) {
                    throw Utils.parameterError(this.method, this.p, "Header map contained null value for key '" + headerName + "'.", new Object[0]);
                }
                builder.addHeader(headerName, this.valueConverter.convert(headerValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Headers extends ParameterHandler<okhttp3.Headers> {
        private final Method method;
        private final int p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Headers(Method method, int p) {
            this.method = method;
            this.p = p;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder builder, @Nullable okhttp3.Headers headers) {
            if (headers == null) {
                throw Utils.parameterError(this.method, this.p, "Headers parameter must not be null.", new Object[0]);
            }
            builder.addHeaders(headers);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(String name, Converter<T, String> valueConverter, boolean encoded) {
            this.name = (String) Objects.requireNonNull(name, "name == null");
            this.valueConverter = valueConverter;
            this.encoded = encoded;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder builder, @Nullable T value) throws IOException {
            String fieldValue;
            if (value == null || (fieldValue = this.valueConverter.convert(value)) == null) {
                return;
            }
            builder.addFormField(this.name, fieldValue, this.encoded);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        @Override // retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public FieldMap(Method method, int p, Converter<T, String> valueConverter, boolean encoded) {
            this.method = method;
            this.p = p;
            this.valueConverter = valueConverter;
            this.encoded = encoded;
        }

        void apply(RequestBuilder builder, @Nullable Map<String, T> value) throws IOException {
            if (value == null) {
                throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : value.entrySet()) {
                String entryKey = entry.getKey();
                if (entryKey == null) {
                    throw Utils.parameterError(this.method, this.p, "Field map contained null key.", new Object[0]);
                }
                T entryValue = entry.getValue();
                if (entryValue == null) {
                    throw Utils.parameterError(this.method, this.p, "Field map contained null value for key '" + entryKey + "'.", new Object[0]);
                }
                String fieldEntry = this.valueConverter.convert(entryValue);
                if (fieldEntry == null) {
                    throw Utils.parameterError(this.method, this.p, "Field map value '" + entryValue + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + entryKey + "'.", new Object[0]);
                }
                builder.addFormField(entryKey, fieldEntry, this.encoded);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final okhttp3.Headers headers;
        private final Method method;
        private final int p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Part(Method method, int p, okhttp3.Headers headers, Converter<T, RequestBody> converter) {
            this.method = method;
            this.p = p;
            this.headers = headers;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder builder, @Nullable T value) {
            if (value == null) {
                return;
            }
            try {
                RequestBody body = this.converter.convert(value);
                builder.addPart(this.headers, body);
            } catch (IOException e) {
                throw Utils.parameterError(this.method, this.p, "Unable to convert " + value + " to RequestBody", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder builder, @Nullable MultipartBody.Part value) {
            if (value != null) {
                builder.addPart(value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;
        private final int p;
        private final String transferEncoding;
        private final Converter<T, RequestBody> valueConverter;

        @Override // retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PartMap(Method method, int p, Converter<T, RequestBody> valueConverter, String transferEncoding) {
            this.method = method;
            this.p = p;
            this.valueConverter = valueConverter;
            this.transferEncoding = transferEncoding;
        }

        void apply(RequestBuilder builder, @Nullable Map<String, T> value) throws IOException {
            if (value == null) {
                throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : value.entrySet()) {
                String entryKey = entry.getKey();
                if (entryKey == null) {
                    throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
                }
                T entryValue = entry.getValue();
                if (entryValue == null) {
                    throw Utils.parameterError(this.method, this.p, "Part map contained null value for key '" + entryKey + "'.", new Object[0]);
                }
                okhttp3.Headers headers = okhttp3.Headers.of("Content-Disposition", "form-data; name=\"" + entryKey + "\"", "Content-Transfer-Encoding", this.transferEncoding);
                builder.addPart(headers, this.valueConverter.convert(entryValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final Method method;
        private final int p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Body(Method method, int p, Converter<T, RequestBody> converter) {
            this.method = method;
            this.p = p;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder builder, @Nullable T value) {
            if (value == null) {
                throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                RequestBody body = this.converter.convert(value);
                builder.setBody(body);
            } catch (IOException e) {
                throw Utils.parameterError(this.method, e, this.p, "Unable to convert " + value + " to RequestBody", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Tag(Class<T> cls) {
            this.cls = cls;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder builder, @Nullable T value) {
            builder.addTag(this.cls, value);
        }
    }
}