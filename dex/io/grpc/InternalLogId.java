package io.grpc;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

public final class InternalLogId {
    private static final AtomicLong idAlloc = new AtomicLong();
    @Nullable
    private final String details;
    private final long id;
    private final String typeName;

    public static InternalLogId allocate(Class<?> type, @Nullable String details) {
        return allocate(getClassName(type), details);
    }

    public static InternalLogId allocate(String typeName, @Nullable String details) {
        return new InternalLogId(typeName, details, getNextId());
    }

    static long getNextId() {
        return idAlloc.incrementAndGet();
    }

    InternalLogId(String typeName, String details, long id) {
        Preconditions.checkNotNull(typeName, "typeName");
        Preconditions.checkArgument(!typeName.isEmpty(), "empty type");
        this.typeName = typeName;
        this.details = details;
        this.id = id;
    }

    public String getTypeName() {
        return this.typeName;
    }

    @Nullable
    public String getDetails() {
        return this.details;
    }

    public long getId() {
        return this.id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(shortName());
        if (this.details != null) {
            sb.append(": (");
            sb.append(this.details);
            sb.append(')');
        }
        return sb.toString();
    }

    private static String getClassName(Class<?> type) {
        String className = ((Class) Preconditions.checkNotNull(type, "type")).getSimpleName();
        if (!className.isEmpty()) {
            return className;
        }
        return type.getName().substring(type.getPackage().getName().length() + 1);
    }

    public String shortName() {
        return this.typeName + "<" + this.id + ">";
    }
}