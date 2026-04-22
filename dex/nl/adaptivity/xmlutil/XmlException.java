package nl.adaptivity.xmlutil;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nl.adaptivity.xmlutil.XmlReader;

/* compiled from: XmlException.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\b\u0017\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eB\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000fB!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0005\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0017H\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lnl/adaptivity/xmlutil/XmlException;", "Ljava/io/IOException;", "Lnl/adaptivity/xmlutil/core/impl/multiplatform/IOException;", "locationInfo", "Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "<init>", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;)V", "message", "", "(Ljava/lang/String;Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/String;Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "(Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;Ljava/lang/Throwable;)V", "reader", "Lnl/adaptivity/xmlutil/XmlReader;", "(Ljava/lang/String;Lnl/adaptivity/xmlutil/XmlReader;Ljava/lang/Throwable;)V", "(Ljava/lang/String;Lnl/adaptivity/xmlutil/XmlReader;)V", "getLocationInfo", "()Lnl/adaptivity/xmlutil/XmlReader$LocationInfo;", "doThrow", "", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class XmlException extends IOException {
    private final XmlReader.LocationInfo locationInfo;

    public final XmlReader.LocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    public /* synthetic */ XmlException(XmlReader.LocationInfo locationInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : locationInfo);
    }

    public XmlException(XmlReader.LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public XmlException() {
        this((XmlReader.LocationInfo) null, 1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ XmlException(String str, XmlReader.LocationInfo locationInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : locationInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XmlException(String message, XmlReader.LocationInfo locationInfo) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        this.locationInfo = locationInfo;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XmlException(String message) {
        this(message, null, 2, null);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XmlException(String message, Throwable cause) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.locationInfo = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XmlException(String message, XmlReader.LocationInfo locationInfo, Throwable cause) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.locationInfo = locationInfo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XmlException(Throwable cause) {
        super(cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.locationInfo = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XmlException(XmlReader.LocationInfo locationInfo, Throwable cause) {
        super(cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.locationInfo = locationInfo;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public XmlException(String message, XmlReader reader, Throwable cause) {
        super(r0.append(r1 == null ? "Unknown position" : r1).append(" - ").append(message).toString(), cause);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(cause, "cause");
        StringBuilder sb = new StringBuilder();
        String extLocationInfo = reader.getExtLocationInfo();
        this.locationInfo = reader.getExtLocationInfo();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public XmlException(String message, XmlReader reader) {
        super(r0.append(r1 == null ? "Unknown position" : r1).append(" - ").append(message).toString());
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(reader, "reader");
        StringBuilder sb = new StringBuilder();
        String extLocationInfo = reader.getExtLocationInfo();
        this.locationInfo = reader.getExtLocationInfo();
    }

    @Deprecated(message = "Only use in Java, in kotlin just throw", replaceWith = @ReplaceWith(expression = "throw this", imports = {}))
    public final Void doThrow() {
        throw this;
    }
}