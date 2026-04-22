package retrofit2;

import j$.util.Optional;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: Access modifiers changed from: package-private */
public final class OptionalConverterFactory extends Converter.Factory {
    static final Converter.Factory INSTANCE = new OptionalConverterFactory();

    OptionalConverterFactory() {
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(type) != Optional.class) {
            return null;
        }
        Type innerType = getParameterUpperBound(0, (ParameterizedType) type);
        Converter<ResponseBody, Object> delegate = retrofit.responseBodyConverter(innerType, annotations);
        return new OptionalConverter(delegate);
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    static final class OptionalConverter<T> implements Converter<ResponseBody, Optional<T>> {
        final Converter<ResponseBody, T> delegate;

        OptionalConverter(Converter<ResponseBody, T> delegate) {
            this.delegate = delegate;
        }

        @Override // retrofit2.Converter
        public Optional<T> convert(ResponseBody value) throws IOException {
            return Optional.ofNullable(this.delegate.convert(value));
        }
    }
}