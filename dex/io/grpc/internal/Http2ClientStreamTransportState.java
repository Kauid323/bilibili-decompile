package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import io.grpc.InternalMetadata;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractClientStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract class Http2ClientStreamTransportState extends AbstractClientStream.TransportState {
    private Charset errorCharset;
    private boolean headersReceived;
    private Status transportError;
    private Metadata transportErrorMetadata;
    private static final InternalMetadata.TrustedAsciiMarshaller<Integer> HTTP_STATUS_MARSHALLER = new InternalMetadata.TrustedAsciiMarshaller<Integer>() { // from class: io.grpc.internal.Http2ClientStreamTransportState.1
        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(Integer value) {
            throw new UnsupportedOperationException();
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public Integer parseAsciiString(byte[] serialized) {
            if (serialized.length >= 3) {
                return Integer.valueOf(((serialized[0] - 48) * 100) + ((serialized[1] - 48) * 10) + (serialized[2] - 48));
            }
            throw new NumberFormatException("Malformed status code " + new String(serialized, InternalMetadata.US_ASCII));
        }
    };
    private static final Metadata.Key<Integer> HTTP2_STATUS = InternalMetadata.keyOf(":status", HTTP_STATUS_MARSHALLER);

    protected abstract void http2ProcessingFailed(Status status, boolean z, Metadata metadata);

    @Override // io.grpc.internal.AbstractClientStream.TransportState, io.grpc.internal.MessageDeframer.Listener
    public /* bridge */ /* synthetic */ void deframerClosed(boolean z) {
        super.deframerClosed(z);
    }

    protected Http2ClientStreamTransportState(int maxMessageSize, StatsTraceContext statsTraceCtx, TransportTracer transportTracer) {
        super(maxMessageSize, statsTraceCtx, transportTracer);
        this.errorCharset = Charsets.UTF_8;
    }

    /* JADX WARN: Finally extract failed */
    protected void transportHeadersReceived(Metadata headers) {
        Preconditions.checkNotNull(headers, "headers");
        if (this.transportError != null) {
            this.transportError = this.transportError.augmentDescription("headers: " + headers);
            return;
        }
        try {
            if (this.headersReceived) {
                this.transportError = Status.INTERNAL.withDescription("Received headers twice");
                if (this.transportError != null) {
                    this.transportError = this.transportError.augmentDescription("headers: " + headers);
                    this.transportErrorMetadata = headers;
                    this.errorCharset = extractCharset(headers);
                    return;
                }
                return;
            }
            Integer httpStatus = (Integer) headers.get(HTTP2_STATUS);
            if (httpStatus != null && httpStatus.intValue() >= 100 && httpStatus.intValue() < 200) {
                if (this.transportError != null) {
                    this.transportError = this.transportError.augmentDescription("headers: " + headers);
                    this.transportErrorMetadata = headers;
                    this.errorCharset = extractCharset(headers);
                    return;
                }
                return;
            }
            this.headersReceived = true;
            this.transportError = validateInitialMetadata(headers);
            if (this.transportError != null) {
                if (this.transportError != null) {
                    this.transportError = this.transportError.augmentDescription("headers: " + headers);
                    this.transportErrorMetadata = headers;
                    this.errorCharset = extractCharset(headers);
                    return;
                }
                return;
            }
            stripTransportDetails(headers);
            inboundHeadersReceived(headers);
            if (this.transportError != null) {
                this.transportError = this.transportError.augmentDescription("headers: " + headers);
                this.transportErrorMetadata = headers;
                this.errorCharset = extractCharset(headers);
            }
        } catch (Throwable th) {
            if (this.transportError != null) {
                this.transportError = this.transportError.augmentDescription("headers: " + headers);
                this.transportErrorMetadata = headers;
                this.errorCharset = extractCharset(headers);
            }
            throw th;
        }
    }

    protected void transportDataReceived(ReadableBuffer frame, boolean endOfStream) {
        if (this.transportError != null) {
            this.transportError = this.transportError.augmentDescription("DATA-----------------------------\n" + ReadableBuffers.readAsString(frame, this.errorCharset));
            frame.close();
            if (this.transportError.getDescription().length() > 1000 || endOfStream) {
                http2ProcessingFailed(this.transportError, false, this.transportErrorMetadata);
            }
        } else if (!this.headersReceived) {
            http2ProcessingFailed(Status.INTERNAL.withDescription("headers not received before payload"), false, new Metadata());
        } else {
            int frameSize = frame.readableBytes();
            inboundDataReceived(frame);
            if (endOfStream) {
                if (frameSize > 0) {
                    this.transportError = Status.INTERNAL.withDescription("Received unexpected EOS on non-empty DATA frame from server");
                } else {
                    this.transportError = Status.INTERNAL.withDescription("Received unexpected EOS on empty DATA frame from server");
                }
                this.transportErrorMetadata = new Metadata();
                transportReportStatus(this.transportError, false, this.transportErrorMetadata);
            }
        }
    }

    protected void transportTrailersReceived(Metadata trailers) {
        Preconditions.checkNotNull(trailers, GrpcUtil.TE_TRAILERS);
        if (this.transportError == null && !this.headersReceived) {
            this.transportError = validateInitialMetadata(trailers);
            if (this.transportError != null) {
                this.transportErrorMetadata = trailers;
            }
        }
        if (this.transportError != null) {
            this.transportError = this.transportError.augmentDescription("trailers: " + trailers);
            http2ProcessingFailed(this.transportError, false, this.transportErrorMetadata);
            return;
        }
        Status status = statusFromTrailers(trailers);
        stripTransportDetails(trailers);
        inboundTrailersReceived(trailers, status);
    }

    private Status statusFromTrailers(Metadata trailers) {
        Status status;
        Status status2 = (Status) trailers.get(InternalStatus.CODE_KEY);
        if (status2 != null) {
            return status2.withDescription((String) trailers.get(InternalStatus.MESSAGE_KEY));
        }
        if (this.headersReceived) {
            return Status.UNKNOWN.withDescription("missing GRPC status in response");
        }
        Integer httpStatus = (Integer) trailers.get(HTTP2_STATUS);
        if (httpStatus != null) {
            status = GrpcUtil.httpStatusToGrpcStatus(httpStatus.intValue());
        } else {
            status = Status.INTERNAL.withDescription("missing HTTP status code");
        }
        return status.augmentDescription("missing GRPC status, inferred error from HTTP status code");
    }

    @Nullable
    private Status validateInitialMetadata(Metadata headers) {
        Integer httpStatus = (Integer) headers.get(HTTP2_STATUS);
        if (httpStatus == null) {
            return Status.INTERNAL.withDescription("Missing HTTP status code");
        }
        String contentType = (String) headers.get(GrpcUtil.CONTENT_TYPE_KEY);
        if (!GrpcUtil.isGrpcContentType(contentType)) {
            return GrpcUtil.httpStatusToGrpcStatus(httpStatus.intValue()).augmentDescription("invalid content-type: " + contentType);
        }
        return null;
    }

    private static Charset extractCharset(Metadata headers) {
        String contentType = (String) headers.get(GrpcUtil.CONTENT_TYPE_KEY);
        if (contentType != null) {
            String[] split = contentType.split("charset=", 2);
            try {
                return Charset.forName(split[split.length - 1].trim());
            } catch (Exception e2) {
            }
        }
        return Charsets.UTF_8;
    }

    private static void stripTransportDetails(Metadata metadata) {
        metadata.discardAll(HTTP2_STATUS);
        metadata.discardAll(InternalStatus.CODE_KEY);
        metadata.discardAll(InternalStatus.MESSAGE_KEY);
    }
}