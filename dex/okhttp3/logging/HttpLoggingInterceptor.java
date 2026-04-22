package okhttp3.logging;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: okhttp3.logging.HttpLoggingInterceptor.Logger.1
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public void log(String message) {
                Platform.get().log(4, message, null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.headersToRedact = Collections.emptySet();
        this.level = Level.NONE;
        this.logger = logger;
    }

    public void redactHeader(String name) {
        Set<String> newHeadersToRedact = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        newHeadersToRedact.addAll(this.headersToRedact);
        newHeadersToRedact.add(name);
        this.headersToRedact = newHeadersToRedact;
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level;
        return this;
    }

    public Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        String requestStartMessage;
        Level level;
        String str2;
        long contentLength;
        char c;
        String str3;
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain.proceed(request);
        }
        boolean logBody = level2 == Level.BODY;
        boolean logHeaders = logBody || level2 == Level.HEADERS;
        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;
        Connection connection = chain.connection();
        String requestStartMessage2 = "--> " + request.method() + ' ' + request.url() + (connection != null ? " " + connection.protocol() : "");
        if (logHeaders || !hasRequestBody) {
            str = "";
            requestStartMessage = requestStartMessage2;
        } else {
            str = "";
            requestStartMessage = requestStartMessage2 + " (" + requestBody.contentLength() + "-byte body)";
        }
        this.logger.log(requestStartMessage);
        if (!logHeaders) {
            level = level2;
            str2 = str;
        } else {
            if (!hasRequestBody) {
                level = level2;
            } else {
                if (requestBody.contentType() != null) {
                    this.logger.log("Content-Type: " + requestBody.contentType());
                }
                if (requestBody.contentLength() == -1) {
                    level = level2;
                } else {
                    level = level2;
                    this.logger.log("Content-Length: " + requestBody.contentLength());
                }
            }
            Headers headers = request.headers();
            int i = 0;
            int count = headers.size();
            while (i < count) {
                String name = headers.name(i);
                Connection connection2 = connection;
                if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                    logHeader(headers, i);
                }
                i++;
                connection = connection2;
            }
            if (!logBody) {
                str2 = str;
            } else if (!hasRequestBody) {
                str2 = str;
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                str2 = str;
            } else {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                Charset charset = UTF8;
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }
                str2 = str;
                this.logger.log(str2);
                if (isPlaintext(buffer)) {
                    this.logger.log(buffer.readString(charset));
                    this.logger.log("--> END " + request.method() + " (" + requestBody.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + requestBody.contentLength() + "-byte body omitted)");
                }
            }
            this.logger.log("--> END " + request.method());
        }
        long startNs = System.nanoTime();
        try {
            Response response = chain.proceed(request);
            long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
            ResponseBody responseBody = response.body();
            long contentLength2 = responseBody.contentLength();
            String bodySize = contentLength2 != -1 ? contentLength2 + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder append = new StringBuilder().append("<-- ").append(response.code());
            if (response.message().isEmpty()) {
                contentLength = contentLength2;
                str3 = str2;
                c = ' ';
            } else {
                contentLength = contentLength2;
                c = ' ';
                str3 = ' ' + response.message();
            }
            logger.log(append.append(str3).append(c).append(response.request().url()).append(" (").append(tookMs).append("ms").append(!logHeaders ? ", " + bodySize + " body" : str2).append(')').toString());
            if (logHeaders) {
                Headers headers2 = response.headers();
                int count2 = headers2.size();
                for (int i2 = 0; i2 < count2; i2++) {
                    logHeader(headers2, i2);
                }
                if (logBody && HttpHeaders.hasBody(response)) {
                    if (bodyHasUnknownEncoding(response.headers())) {
                        this.logger.log("<-- END HTTP (encoded body omitted)");
                    } else {
                        BufferedSource source = responseBody.source();
                        source.request(LongCompanionObject.MAX_VALUE);
                        Buffer buffer2 = source.buffer();
                        Long gzippedLength = null;
                        if ("gzip".equalsIgnoreCase(headers2.get("Content-Encoding"))) {
                            gzippedLength = Long.valueOf(buffer2.size());
                            GzipSource gzippedResponseBody = null;
                            try {
                                try {
                                    gzippedResponseBody = new GzipSource(buffer2.clone());
                                    buffer2 = new Buffer();
                                    buffer2.writeAll(gzippedResponseBody);
                                    gzippedResponseBody.close();
                                } catch (Throwable th) {
                                    th = th;
                                    if (gzippedResponseBody != null) {
                                        gzippedResponseBody.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        Charset charset2 = UTF8;
                        MediaType contentType2 = responseBody.contentType();
                        if (contentType2 != null) {
                            charset2 = contentType2.charset(UTF8);
                        }
                        if (!isPlaintext(buffer2)) {
                            this.logger.log(str2);
                            this.logger.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                            return response;
                        }
                        if (contentLength != 0) {
                            this.logger.log(str2);
                            this.logger.log(buffer2.clone().readString(charset2));
                        }
                        if (gzippedLength == null) {
                            this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                        } else {
                            this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte, " + gzippedLength + "-gzipped-byte body)");
                        }
                    }
                }
                this.logger.log("<-- END HTTP");
            }
            return response;
        } catch (Exception e) {
            this.logger.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    private void logHeader(Headers headers, int i) {
        String value = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        this.logger.log(headers.name(i) + ": " + value);
    }

    static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64L;
            buffer.copyTo(prefix, 0L, byteCount);
            for (int i = 0; i < 16; i++) {
                if (!prefix.exhausted()) {
                    int codePoint = prefix.readUtf8CodePoint();
                    if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                        return false;
                    }
                } else {
                    return true;
                }
            }
            return true;
        } catch (EOFException e) {
            return false;
        }
    }

    private static boolean bodyHasUnknownEncoding(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return (contentEncoding == null || contentEncoding.equalsIgnoreCase("identity") || contentEncoding.equalsIgnoreCase("gzip")) ? false : true;
    }
}