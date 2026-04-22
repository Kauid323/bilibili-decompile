package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

public final class ServiceDescriptor {
    private final Collection<MethodDescriptor<?, ?>> methods;
    private final String name;
    private final Object schemaDescriptor;

    public ServiceDescriptor(String name, MethodDescriptor<?, ?>... methods) {
        this(name, Arrays.asList(methods));
    }

    public ServiceDescriptor(String name, Collection<MethodDescriptor<?, ?>> methods) {
        this(newBuilder(name).addAllMethods((Collection) Preconditions.checkNotNull(methods, "methods")));
    }

    private ServiceDescriptor(Builder b) {
        this.name = b.name;
        validateMethodNames(this.name, b.methods);
        this.methods = Collections.unmodifiableList(new ArrayList(b.methods));
        this.schemaDescriptor = b.schemaDescriptor;
    }

    public String getName() {
        return this.name;
    }

    public Collection<MethodDescriptor<?, ?>> getMethods() {
        return this.methods;
    }

    @Nullable
    public Object getSchemaDescriptor() {
        return this.schemaDescriptor;
    }

    static void validateMethodNames(String serviceName, Collection<MethodDescriptor<?, ?>> methods) {
        Set<String> allNames = new HashSet<>(methods.size());
        for (MethodDescriptor<?, ?> method : methods) {
            Preconditions.checkNotNull(method, "method");
            String methodServiceName = method.getServiceName();
            Preconditions.checkArgument(serviceName.equals(methodServiceName), "service names %s != %s", methodServiceName, serviceName);
            Preconditions.checkArgument(allNames.add(method.getFullMethodName()), "duplicate name %s", method.getFullMethodName());
        }
    }

    public static Builder newBuilder(String name) {
        return new Builder(name);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Builder {
        private List<MethodDescriptor<?, ?>> methods;
        private String name;
        private Object schemaDescriptor;

        private Builder(String name) {
            this.methods = new ArrayList();
            setName(name);
        }

        public Builder setName(String name) {
            this.name = (String) Preconditions.checkNotNull(name, ContentDisposition.Parameters.Name);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder addMethod(MethodDescriptor<?, ?> method) {
            this.methods.add(Preconditions.checkNotNull(method, "method"));
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder addAllMethods(Collection<MethodDescriptor<?, ?>> methods) {
            this.methods.addAll(methods);
            return this;
        }

        public Builder setSchemaDescriptor(@Nullable Object schemaDescriptor) {
            this.schemaDescriptor = schemaDescriptor;
            return this;
        }

        public ServiceDescriptor build() {
            return new ServiceDescriptor(this);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(ContentDisposition.Parameters.Name, this.name).add("schemaDescriptor", this.schemaDescriptor).add("methods", this.methods).omitNullValues().toString();
    }
}