package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.ParameterHandler;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;

/* JADX INFO: Access modifiers changed from: package-private */
public final class RequestFactory {
    private final HttpUrl baseUrl;
    @Nullable
    private final MediaType contentType;
    private final boolean hasBody;
    @Nullable
    private final Headers headers;
    final String httpMethod;
    private final boolean isFormEncoded;
    final boolean isKotlinSuspendFunction;
    private final boolean isMultipart;
    private final Method method;
    private final ParameterHandler<?>[] parameterHandlers;
    @Nullable
    private final String relativeUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RequestFactory parseAnnotations(Retrofit retrofit, Method method) {
        return new Builder(retrofit, method).build();
    }

    RequestFactory(Builder builder) {
        this.method = builder.method;
        this.baseUrl = builder.retrofit.baseUrl;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
        this.isKotlinSuspendFunction = builder.isKotlinSuspendFunction;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request create(Object[] args) throws IOException {
        ParameterHandler<Object>[] handlers = this.parameterHandlers;
        int argumentCount = args.length;
        if (argumentCount != handlers.length) {
            throw new IllegalArgumentException("Argument count (" + argumentCount + ") doesn't match expected count (" + handlers.length + ")");
        }
        RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
        if (this.isKotlinSuspendFunction) {
            argumentCount--;
        }
        List<Object> argumentList = new ArrayList<>(argumentCount);
        for (int p = 0; p < argumentCount; p++) {
            argumentList.add(args[p]);
            handlers[p].apply(requestBuilder, args[p]);
        }
        return requestBuilder.get().tag(Invocation.class, new Invocation(this.method, argumentList)).build();
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    static final class Builder {
        @Nullable
        MediaType contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotQueryMap;
        boolean gotQueryName;
        boolean gotUrl;
        boolean hasBody;
        @Nullable
        Headers headers;
        @Nullable
        String httpMethod;
        boolean isFormEncoded;
        boolean isKotlinSuspendFunction;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        @Nullable
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        @Nullable
        String relativeUrl;
        @Nullable
        Set<String> relativeUrlParamNames;
        final Retrofit retrofit;
        private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
        private static final Pattern PARAM_NAME_REGEX = Pattern.compile(PARAM);

        Builder(Retrofit retrofit, Method method) {
            this.retrofit = retrofit;
            this.method = method;
            this.methodAnnotations = method.getAnnotations();
            this.parameterTypes = method.getGenericParameterTypes();
            this.parameterAnnotationsArray = method.getParameterAnnotations();
        }

        RequestFactory build() {
            Annotation[] annotationArr;
            for (Annotation annotation : this.methodAnnotations) {
                parseMethodAnnotation(annotation);
            }
            if (this.httpMethod == null) {
                throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.hasBody) {
                if (this.isMultipart) {
                    throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.isFormEncoded) {
                    throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int parameterCount = this.parameterAnnotationsArray.length;
            this.parameterHandlers = new ParameterHandler[parameterCount];
            int p = 0;
            int lastParameter = parameterCount - 1;
            while (true) {
                boolean z = true;
                if (p >= parameterCount) {
                    break;
                }
                ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
                Type type = this.parameterTypes[p];
                Annotation[] annotationArr2 = this.parameterAnnotationsArray[p];
                if (p != lastParameter) {
                    z = false;
                }
                parameterHandlerArr[p] = parseParameter(p, type, annotationArr2, z);
                p++;
            }
            if (this.relativeUrl != null || this.gotUrl) {
                if (!this.isFormEncoded && !this.isMultipart && !this.hasBody && this.gotBody) {
                    throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                }
                if (this.isFormEncoded && !this.gotField) {
                    throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
                }
                if (this.isMultipart && !this.gotPart) {
                    throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
                }
                return new RequestFactory(this);
            }
            throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", this.httpMethod);
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof DELETE) {
                parseHttpMethodAndPath("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                parseHttpMethodAndPath("GET", ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                parseHttpMethodAndPath("HEAD", ((HEAD) annotation).value(), false);
            } else if (annotation instanceof PATCH) {
                parseHttpMethodAndPath("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                parseHttpMethodAndPath("POST", ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                parseHttpMethodAndPath("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                parseHttpMethodAndPath("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof retrofit2.http.Headers) {
                String[] headersToParse = ((retrofit2.http.Headers) annotation).value();
                if (headersToParse.length == 0) {
                    throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
                }
                this.headers = parseHeaders(headersToParse);
            } else if (annotation instanceof Multipart) {
                if (this.isFormEncoded) {
                    throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.isMultipart = true;
            } else if (annotation instanceof FormUrlEncoded) {
                if (this.isMultipart) {
                    throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.isFormEncoded = true;
            }
        }

        private void parseHttpMethodAndPath(String httpMethod, String value, boolean hasBody) {
            if (this.httpMethod != null) {
                throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", this.httpMethod, httpMethod);
            }
            this.httpMethod = httpMethod;
            this.hasBody = hasBody;
            if (value.isEmpty()) {
                return;
            }
            int question = value.indexOf(63);
            if (question != -1 && question < value.length() - 1) {
                String queryParams = value.substring(question + 1);
                Matcher queryParamMatcher = PARAM_URL_REGEX.matcher(queryParams);
                if (queryParamMatcher.find()) {
                    throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", queryParams);
                }
            }
            this.relativeUrl = value;
            this.relativeUrlParamNames = parsePathParameters(value);
        }

        private Headers parseHeaders(String[] headers) {
            Headers.Builder builder = new Headers.Builder();
            for (String header : headers) {
                int colon = header.indexOf(58);
                if (colon == -1 || colon == 0 || colon == header.length() - 1) {
                    throw Utils.methodError(this.method, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", header);
                }
                String headerName = header.substring(0, colon);
                String headerValue = header.substring(colon + 1).trim();
                if ("Content-Type".equalsIgnoreCase(headerName)) {
                    try {
                        this.contentType = MediaType.get(headerValue);
                    } catch (IllegalArgumentException e) {
                        throw Utils.methodError(this.method, e, "Malformed content type: %s", headerValue);
                    }
                } else {
                    builder.add(headerName, headerValue);
                }
            }
            return builder.build();
        }

        @Nullable
        private ParameterHandler<?> parseParameter(int p, Type parameterType, @Nullable Annotation[] annotations, boolean allowContinuation) {
            ParameterHandler<?> result = null;
            if (annotations != null) {
                for (Annotation annotation : annotations) {
                    ParameterHandler<?> annotationAction = parseParameterAnnotation(p, parameterType, annotations, annotation);
                    if (annotationAction != null) {
                        if (result != null) {
                            throw Utils.parameterError(this.method, p, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        result = annotationAction;
                    }
                }
            }
            if (result == null) {
                if (allowContinuation) {
                    try {
                        if (Utils.getRawType(parameterType) == Continuation.class) {
                            this.isKotlinSuspendFunction = true;
                            return null;
                        }
                    } catch (NoClassDefFoundError e) {
                    }
                }
                throw Utils.parameterError(this.method, p, "No Retrofit annotation found.", new Object[0]);
            }
            return result;
        }

        @Nullable
        private ParameterHandler<?> parseParameterAnnotation(int p, Type type, Annotation[] annotations, Annotation annotation) {
            if (annotation instanceof Url) {
                validateResolvableType(p, type);
                if (this.gotUrl) {
                    throw Utils.parameterError(this.method, p, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.gotPath) {
                    throw Utils.parameterError(this.method, p, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.gotQuery) {
                    throw Utils.parameterError(this.method, p, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.gotQueryName) {
                    throw Utils.parameterError(this.method, p, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.gotQueryMap) {
                    throw Utils.parameterError(this.method, p, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.relativeUrl == null) {
                    this.gotUrl = true;
                    if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new ParameterHandler.RelativeUrl(this.method, p);
                    }
                    throw Utils.parameterError(this.method, p, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                }
                throw Utils.parameterError(this.method, p, "@Url cannot be used with @%s URL", this.httpMethod);
            } else if (annotation instanceof Path) {
                validateResolvableType(p, type);
                if (this.gotQuery) {
                    throw Utils.parameterError(this.method, p, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.gotQueryName) {
                    throw Utils.parameterError(this.method, p, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.gotQueryMap) {
                    throw Utils.parameterError(this.method, p, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.gotUrl) {
                    throw Utils.parameterError(this.method, p, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.relativeUrl != null) {
                    this.gotPath = true;
                    Path path = (Path) annotation;
                    String name = path.value();
                    validatePathName(p, name);
                    Converter<?, String> converter = this.retrofit.stringConverter(type, annotations);
                    return new ParameterHandler.Path(this.method, p, name, converter, path.encoded());
                }
                throw Utils.parameterError(this.method, p, "@Path can only be used with relative url on @%s", this.httpMethod);
            } else if (annotation instanceof Query) {
                validateResolvableType(p, type);
                Query query = (Query) annotation;
                String name2 = query.value();
                boolean encoded = query.encoded();
                Class<?> rawParameterType = Utils.getRawType(type);
                this.gotQuery = true;
                if (Iterable.class.isAssignableFrom(rawParameterType)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw Utils.parameterError(this.method, p, rawParameterType.getSimpleName() + " must include generic type (e.g., " + rawParameterType.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Converter<?, String> converter2 = this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotations);
                    return new ParameterHandler.Query(name2, converter2, encoded).iterable();
                } else if (rawParameterType.isArray()) {
                    Converter<?, String> converter3 = this.retrofit.stringConverter(boxIfPrimitive(rawParameterType.getComponentType()), annotations);
                    return new ParameterHandler.Query(name2, converter3, encoded).array();
                } else {
                    Converter<?, String> converter4 = this.retrofit.stringConverter(type, annotations);
                    return new ParameterHandler.Query(name2, converter4, encoded);
                }
            } else if (annotation instanceof QueryName) {
                validateResolvableType(p, type);
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class<?> rawParameterType2 = Utils.getRawType(type);
                this.gotQueryName = true;
                if (Iterable.class.isAssignableFrom(rawParameterType2)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw Utils.parameterError(this.method, p, rawParameterType2.getSimpleName() + " must include generic type (e.g., " + rawParameterType2.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Converter<?, String> converter5 = this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotations);
                    return new ParameterHandler.QueryName(converter5, encoded2).iterable();
                } else if (rawParameterType2.isArray()) {
                    Converter<?, String> converter6 = this.retrofit.stringConverter(boxIfPrimitive(rawParameterType2.getComponentType()), annotations);
                    return new ParameterHandler.QueryName(converter6, encoded2).array();
                } else {
                    Converter<?, String> converter7 = this.retrofit.stringConverter(type, annotations);
                    return new ParameterHandler.QueryName(converter7, encoded2);
                }
            } else if (annotation instanceof QueryMap) {
                validateResolvableType(p, type);
                Class<?> rawParameterType3 = Utils.getRawType(type);
                this.gotQueryMap = true;
                if (!Map.class.isAssignableFrom(rawParameterType3)) {
                    throw Utils.parameterError(this.method, p, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type mapType = Utils.getSupertype(type, rawParameterType3, Map.class);
                if (!(mapType instanceof ParameterizedType)) {
                    throw Utils.parameterError(this.method, p, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) mapType;
                Type keyType = Utils.getParameterUpperBound(0, parameterizedType);
                if (String.class != keyType) {
                    throw Utils.parameterError(this.method, p, "@QueryMap keys must be of type String: " + keyType, new Object[0]);
                }
                Converter<?, String> valueConverter = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType), annotations);
                return new ParameterHandler.QueryMap(this.method, p, valueConverter, ((QueryMap) annotation).encoded());
            } else if (annotation instanceof Header) {
                validateResolvableType(p, type);
                Header header = (Header) annotation;
                String name3 = header.value();
                Class<?> rawParameterType4 = Utils.getRawType(type);
                if (Iterable.class.isAssignableFrom(rawParameterType4)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw Utils.parameterError(this.method, p, rawParameterType4.getSimpleName() + " must include generic type (e.g., " + rawParameterType4.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Converter<?, String> converter8 = this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotations);
                    return new ParameterHandler.Header(name3, converter8).iterable();
                } else if (rawParameterType4.isArray()) {
                    Converter<?, String> converter9 = this.retrofit.stringConverter(boxIfPrimitive(rawParameterType4.getComponentType()), annotations);
                    return new ParameterHandler.Header(name3, converter9).array();
                } else {
                    Converter<?, String> converter10 = this.retrofit.stringConverter(type, annotations);
                    return new ParameterHandler.Header(name3, converter10);
                }
            } else if (annotation instanceof HeaderMap) {
                if (type == Headers.class) {
                    return new ParameterHandler.Headers(this.method, p);
                }
                validateResolvableType(p, type);
                Class<?> rawParameterType5 = Utils.getRawType(type);
                if (!Map.class.isAssignableFrom(rawParameterType5)) {
                    throw Utils.parameterError(this.method, p, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type mapType2 = Utils.getSupertype(type, rawParameterType5, Map.class);
                if (!(mapType2 instanceof ParameterizedType)) {
                    throw Utils.parameterError(this.method, p, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) mapType2;
                Type keyType2 = Utils.getParameterUpperBound(0, parameterizedType2);
                if (String.class != keyType2) {
                    throw Utils.parameterError(this.method, p, "@HeaderMap keys must be of type String: " + keyType2, new Object[0]);
                }
                Converter<?, String> valueConverter2 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType2), annotations);
                return new ParameterHandler.HeaderMap(this.method, p, valueConverter2);
            } else if (annotation instanceof Field) {
                validateResolvableType(p, type);
                if (!this.isFormEncoded) {
                    throw Utils.parameterError(this.method, p, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Field field = (Field) annotation;
                String name4 = field.value();
                boolean encoded3 = field.encoded();
                this.gotField = true;
                Class<?> rawParameterType6 = Utils.getRawType(type);
                if (Iterable.class.isAssignableFrom(rawParameterType6)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw Utils.parameterError(this.method, p, rawParameterType6.getSimpleName() + " must include generic type (e.g., " + rawParameterType6.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Converter<?, String> converter11 = this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotations);
                    return new ParameterHandler.Field(name4, converter11, encoded3).iterable();
                } else if (rawParameterType6.isArray()) {
                    Converter<?, String> converter12 = this.retrofit.stringConverter(boxIfPrimitive(rawParameterType6.getComponentType()), annotations);
                    return new ParameterHandler.Field(name4, converter12, encoded3).array();
                } else {
                    Converter<?, String> converter13 = this.retrofit.stringConverter(type, annotations);
                    return new ParameterHandler.Field(name4, converter13, encoded3);
                }
            } else if (annotation instanceof FieldMap) {
                validateResolvableType(p, type);
                if (!this.isFormEncoded) {
                    throw Utils.parameterError(this.method, p, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> rawParameterType7 = Utils.getRawType(type);
                if (!Map.class.isAssignableFrom(rawParameterType7)) {
                    throw Utils.parameterError(this.method, p, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type mapType3 = Utils.getSupertype(type, rawParameterType7, Map.class);
                if (!(mapType3 instanceof ParameterizedType)) {
                    throw Utils.parameterError(this.method, p, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) mapType3;
                Type keyType3 = Utils.getParameterUpperBound(0, parameterizedType3);
                if (String.class != keyType3) {
                    throw Utils.parameterError(this.method, p, "@FieldMap keys must be of type String: " + keyType3, new Object[0]);
                }
                Converter<?, String> valueConverter3 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType3), annotations);
                this.gotField = true;
                return new ParameterHandler.FieldMap(this.method, p, valueConverter3, ((FieldMap) annotation).encoded());
            } else if (annotation instanceof Part) {
                validateResolvableType(p, type);
                if (!this.isMultipart) {
                    throw Utils.parameterError(this.method, p, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                Part part = (Part) annotation;
                this.gotPart = true;
                String partName = part.value();
                Class<?> rawParameterType8 = Utils.getRawType(type);
                if (partName.isEmpty()) {
                    if (Iterable.class.isAssignableFrom(rawParameterType8)) {
                        if (!(type instanceof ParameterizedType)) {
                            throw Utils.parameterError(this.method, p, rawParameterType8.getSimpleName() + " must include generic type (e.g., " + rawParameterType8.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (!MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) type)))) {
                            throw Utils.parameterError(this.method, p, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        return ParameterHandler.RawPart.INSTANCE.iterable();
                    } else if (rawParameterType8.isArray()) {
                        if (!MultipartBody.Part.class.isAssignableFrom(rawParameterType8.getComponentType())) {
                            throw Utils.parameterError(this.method, p, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        return ParameterHandler.RawPart.INSTANCE.array();
                    } else if (MultipartBody.Part.class.isAssignableFrom(rawParameterType8)) {
                        return ParameterHandler.RawPart.INSTANCE;
                    } else {
                        throw Utils.parameterError(this.method, p, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                }
                Headers headers = Headers.of("Content-Disposition", "form-data; name=\"" + partName + "\"", "Content-Transfer-Encoding", part.encoding());
                if (Iterable.class.isAssignableFrom(rawParameterType8)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw Utils.parameterError(this.method, p, rawParameterType8.getSimpleName() + " must include generic type (e.g., " + rawParameterType8.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Type iterableType = Utils.getParameterUpperBound(0, (ParameterizedType) type);
                    if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(iterableType))) {
                        throw Utils.parameterError(this.method, p, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    Converter<?, RequestBody> converter14 = this.retrofit.requestBodyConverter(iterableType, annotations, this.methodAnnotations);
                    return new ParameterHandler.Part(this.method, p, headers, converter14).iterable();
                } else if (rawParameterType8.isArray()) {
                    Class<?> arrayComponentType = boxIfPrimitive(rawParameterType8.getComponentType());
                    if (MultipartBody.Part.class.isAssignableFrom(arrayComponentType)) {
                        throw Utils.parameterError(this.method, p, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    Converter<?, RequestBody> converter15 = this.retrofit.requestBodyConverter(arrayComponentType, annotations, this.methodAnnotations);
                    return new ParameterHandler.Part(this.method, p, headers, converter15).array();
                } else if (MultipartBody.Part.class.isAssignableFrom(rawParameterType8)) {
                    throw Utils.parameterError(this.method, p, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                } else {
                    Converter<?, RequestBody> converter16 = this.retrofit.requestBodyConverter(type, annotations, this.methodAnnotations);
                    return new ParameterHandler.Part(this.method, p, headers, converter16);
                }
            } else if (annotation instanceof PartMap) {
                validateResolvableType(p, type);
                if (!this.isMultipart) {
                    throw Utils.parameterError(this.method, p, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.gotPart = true;
                Class<?> rawParameterType9 = Utils.getRawType(type);
                if (!Map.class.isAssignableFrom(rawParameterType9)) {
                    throw Utils.parameterError(this.method, p, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type mapType4 = Utils.getSupertype(type, rawParameterType9, Map.class);
                if (!(mapType4 instanceof ParameterizedType)) {
                    throw Utils.parameterError(this.method, p, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) mapType4;
                Type keyType4 = Utils.getParameterUpperBound(0, parameterizedType4);
                if (String.class != keyType4) {
                    throw Utils.parameterError(this.method, p, "@PartMap keys must be of type String: " + keyType4, new Object[0]);
                }
                Type valueType = Utils.getParameterUpperBound(1, parameterizedType4);
                if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(valueType))) {
                    throw Utils.parameterError(this.method, p, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                }
                Converter<?, RequestBody> valueConverter4 = this.retrofit.requestBodyConverter(valueType, annotations, this.methodAnnotations);
                PartMap partMap = (PartMap) annotation;
                return new ParameterHandler.PartMap(this.method, p, valueConverter4, partMap.encoding());
            } else if (annotation instanceof Body) {
                validateResolvableType(p, type);
                if (this.isFormEncoded || this.isMultipart) {
                    throw Utils.parameterError(this.method, p, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.gotBody) {
                    throw Utils.parameterError(this.method, p, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    Converter<?, RequestBody> converter17 = this.retrofit.requestBodyConverter(type, annotations, this.methodAnnotations);
                    this.gotBody = true;
                    return new ParameterHandler.Body(this.method, p, converter17);
                } catch (RuntimeException e) {
                    throw Utils.parameterError(this.method, e, p, "Unable to create @Body converter for %s", type);
                }
            } else if (annotation instanceof Tag) {
                validateResolvableType(p, type);
                Class<?> tagType = Utils.getRawType(type);
                for (int i = p - 1; i >= 0; i--) {
                    ParameterHandler<?> otherHandler = this.parameterHandlers[i];
                    if ((otherHandler instanceof ParameterHandler.Tag) && ((ParameterHandler.Tag) otherHandler).cls.equals(tagType)) {
                        throw Utils.parameterError(this.method, p, "@Tag type " + tagType.getName() + " is duplicate of parameter #" + (i + 1) + " and would always overwrite its value.", new Object[0]);
                    }
                }
                return new ParameterHandler.Tag(tagType);
            } else {
                return null;
            }
        }

        private void validateResolvableType(int p, Type type) {
            if (Utils.hasUnresolvableType(type)) {
                throw Utils.parameterError(this.method, p, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        private void validatePathName(int p, String name) {
            if (!PARAM_NAME_REGEX.matcher(name).matches()) {
                throw Utils.parameterError(this.method, p, "@Path parameter name must match %s. Found: %s", PARAM_URL_REGEX.pattern(), name);
            }
            if (!this.relativeUrlParamNames.contains(name)) {
                throw Utils.parameterError(this.method, p, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, name);
            }
        }

        static Set<String> parsePathParameters(String path) {
            Matcher m = PARAM_URL_REGEX.matcher(path);
            Set<String> patterns = new LinkedHashSet<>();
            while (m.find()) {
                patterns.add(m.group(1));
            }
            return patterns;
        }

        private static Class<?> boxIfPrimitive(Class<?> type) {
            return Boolean.TYPE == type ? Boolean.class : Byte.TYPE == type ? Byte.class : Character.TYPE == type ? Character.class : Double.TYPE == type ? Double.class : Float.TYPE == type ? Float.class : Integer.TYPE == type ? Integer.class : Long.TYPE == type ? Long.class : Short.TYPE == type ? Short.class : type;
        }
    }
}