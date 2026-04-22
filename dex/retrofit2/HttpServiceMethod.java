package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.ResponseBody;
import retrofit2.Utils;

/* JADX INFO: Access modifiers changed from: package-private */
public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final Call.Factory callFactory;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, ResponseT> responseConverter;

    @Nullable
    protected abstract ReturnT adapt(Call<ResponseT> call, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory) {
        boolean continuationWantsResponse;
        Annotation[] annotations;
        Type adapterType;
        boolean isKotlinSuspendFunction = requestFactory.isKotlinSuspendFunction;
        boolean continuationWantsResponse2 = false;
        Annotation[] annotations2 = method.getAnnotations();
        if (isKotlinSuspendFunction) {
            Type[] parameterTypes = method.getGenericParameterTypes();
            Type responseType = Utils.getParameterLowerBound(0, (ParameterizedType) parameterTypes[parameterTypes.length - 1]);
            if (Utils.getRawType(responseType) == Response.class && (responseType instanceof ParameterizedType)) {
                responseType = Utils.getParameterUpperBound(0, (ParameterizedType) responseType);
                continuationWantsResponse2 = true;
            }
            Type parameterizedTypeImpl = new Utils.ParameterizedTypeImpl(null, Call.class, responseType);
            continuationWantsResponse = continuationWantsResponse2;
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations2);
            adapterType = parameterizedTypeImpl;
        } else {
            Type adapterType2 = method.getGenericReturnType();
            continuationWantsResponse = false;
            annotations = annotations2;
            adapterType = adapterType2;
        }
        CallAdapter<ResponseT, ReturnT> callAdapter = createCallAdapter(retrofit, method, adapterType, annotations);
        Type responseType2 = callAdapter.responseType();
        if (responseType2 == okhttp3.Response.class) {
            throw Utils.methodError(method, "'" + Utils.getRawType(responseType2).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (responseType2 == Response.class) {
            throw Utils.methodError(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (requestFactory.httpMethod.equals("HEAD") && !Void.class.equals(responseType2)) {
            throw Utils.methodError(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        Converter<ResponseBody, ResponseT> responseConverter = createResponseConverter(retrofit, method, responseType2);
        Call.Factory callFactory = retrofit.callFactory;
        if (!isKotlinSuspendFunction) {
            return new CallAdapted(requestFactory, callFactory, responseConverter, callAdapter);
        }
        if (continuationWantsResponse) {
            return new SuspendForResponse(requestFactory, callFactory, responseConverter, callAdapter);
        }
        return new SuspendForBody(requestFactory, callFactory, responseConverter, callAdapter, false);
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method, Type returnType, Annotation[] annotations) {
        try {
            return (CallAdapter<ResponseT, ReturnT>) retrofit.callAdapter(returnType, annotations);
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create call adapter for %s", returnType);
        }
    }

    private static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type responseType) {
        Annotation[] annotations = method.getAnnotations();
        try {
            return retrofit.responseBodyConverter(responseType, annotations);
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create converter for %s", responseType);
        }
    }

    HttpServiceMethod(RequestFactory requestFactory, Call.Factory callFactory, Converter<ResponseBody, ResponseT> responseConverter) {
        this.requestFactory = requestFactory;
        this.callFactory = callFactory;
        this.responseConverter = responseConverter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // retrofit2.ServiceMethod
    @Nullable
    public final ReturnT invoke(Object[] args) {
        Call<ResponseT> call = new OkHttpCall<>(this.requestFactory, args, this.callFactory, this.responseConverter);
        return adapt(call, args);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        CallAdapted(RequestFactory requestFactory, Call.Factory callFactory, Converter<ResponseBody, ResponseT> responseConverter, CallAdapter<ResponseT, ReturnT> callAdapter) {
            super(requestFactory, callFactory, responseConverter);
            this.callAdapter = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        protected ReturnT adapt(Call<ResponseT> call, Object[] args) {
            return this.callAdapter.adapt(call);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        SuspendForResponse(RequestFactory requestFactory, Call.Factory callFactory, Converter<ResponseBody, ResponseT> responseConverter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter) {
            super(requestFactory, callFactory, responseConverter);
            this.callAdapter = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        protected Object adapt(Call<ResponseT> call, Object[] args) {
            Call<ResponseT> call2 = this.callAdapter.adapt(call);
            Continuation<Response<ResponseT>> continuation = (Continuation) args[args.length - 1];
            try {
                return KotlinExtensions.awaitResponse(call2, continuation);
            } catch (Exception e) {
                return KotlinExtensions.suspendAndThrow(e, continuation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;

        SuspendForBody(RequestFactory requestFactory, Call.Factory callFactory, Converter<ResponseBody, ResponseT> responseConverter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter, boolean isNullable) {
            super(requestFactory, callFactory, responseConverter);
            this.callAdapter = callAdapter;
            this.isNullable = isNullable;
        }

        @Override // retrofit2.HttpServiceMethod
        protected Object adapt(Call<ResponseT> call, Object[] args) {
            Call<ResponseT> call2 = this.callAdapter.adapt(call);
            Continuation<ResponseT> continuation = (Continuation) args[args.length - 1];
            try {
                if (this.isNullable) {
                    return KotlinExtensions.awaitNullable(call2, continuation);
                }
                return KotlinExtensions.await(call2, continuation);
            } catch (Exception e) {
                return KotlinExtensions.suspendAndThrow(e, continuation);
            }
        }
    }
}