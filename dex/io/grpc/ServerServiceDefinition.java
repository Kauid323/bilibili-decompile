package io.grpc;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ServerServiceDefinition {
    private final Map<String, ServerMethodDefinition<?, ?>> methods;
    private final ServiceDescriptor serviceDescriptor;

    public static Builder builder(String serviceName) {
        return new Builder(serviceName);
    }

    public static Builder builder(ServiceDescriptor serviceDescriptor) {
        return new Builder(serviceDescriptor);
    }

    private ServerServiceDefinition(ServiceDescriptor serviceDescriptor, Map<String, ServerMethodDefinition<?, ?>> methods) {
        this.serviceDescriptor = (ServiceDescriptor) Preconditions.checkNotNull(serviceDescriptor, "serviceDescriptor");
        this.methods = Collections.unmodifiableMap(new HashMap(methods));
    }

    public ServiceDescriptor getServiceDescriptor() {
        return this.serviceDescriptor;
    }

    public Collection<ServerMethodDefinition<?, ?>> getMethods() {
        return this.methods.values();
    }

    public ServerMethodDefinition<?, ?> getMethod(String methodName) {
        return this.methods.get(methodName);
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Builder {
        private final Map<String, ServerMethodDefinition<?, ?>> methods;
        private final ServiceDescriptor serviceDescriptor;
        private final String serviceName;

        private Builder(String serviceName) {
            this.methods = new HashMap();
            this.serviceName = (String) Preconditions.checkNotNull(serviceName, "serviceName");
            this.serviceDescriptor = null;
        }

        private Builder(ServiceDescriptor serviceDescriptor) {
            this.methods = new HashMap();
            this.serviceDescriptor = (ServiceDescriptor) Preconditions.checkNotNull(serviceDescriptor, "serviceDescriptor");
            this.serviceName = serviceDescriptor.getName();
        }

        public <ReqT, RespT> Builder addMethod(MethodDescriptor<ReqT, RespT> method, ServerCallHandler<ReqT, RespT> handler) {
            return addMethod(ServerMethodDefinition.create((MethodDescriptor) Preconditions.checkNotNull(method, "method must not be null"), (ServerCallHandler) Preconditions.checkNotNull(handler, "handler must not be null")));
        }

        public <ReqT, RespT> Builder addMethod(ServerMethodDefinition<ReqT, RespT> def) {
            MethodDescriptor<ReqT, RespT> method = def.getMethodDescriptor();
            Preconditions.checkArgument(this.serviceName.equals(method.getServiceName()), "Method name should be prefixed with service name and separated with '/'. Expected service name: '%s'. Actual fully qualifed method name: '%s'.", this.serviceName, method.getFullMethodName());
            String name = method.getFullMethodName();
            Preconditions.checkState(!this.methods.containsKey(name), "Method by same name already registered: %s", name);
            this.methods.put(name, def);
            return this;
        }

        public ServerServiceDefinition build() {
            ServiceDescriptor serviceDescriptor = this.serviceDescriptor;
            if (serviceDescriptor == null) {
                List<MethodDescriptor<?, ?>> methodDescriptors = new ArrayList<>(this.methods.size());
                for (ServerMethodDefinition<?, ?> serverMethod : this.methods.values()) {
                    methodDescriptors.add(serverMethod.getMethodDescriptor());
                }
                serviceDescriptor = new ServiceDescriptor(this.serviceName, methodDescriptors);
            }
            Map<String, ServerMethodDefinition<?, ?>> tmpMethods = new HashMap<>(this.methods);
            for (MethodDescriptor<?, ?> descriptorMethod : serviceDescriptor.getMethods()) {
                ServerMethodDefinition<?, ?> removed = tmpMethods.remove(descriptorMethod.getFullMethodName());
                if (removed == null) {
                    throw new IllegalStateException("No method bound for descriptor entry " + descriptorMethod.getFullMethodName());
                }
                if (removed.getMethodDescriptor() != descriptorMethod) {
                    throw new IllegalStateException("Bound method for " + descriptorMethod.getFullMethodName() + " not same instance as method in service descriptor");
                }
            }
            if (tmpMethods.size() > 0) {
                throw new IllegalStateException("No entry in descriptor matching bound method " + tmpMethods.values().iterator().next().getMethodDescriptor().getFullMethodName());
            }
            return new ServerServiceDefinition(serviceDescriptor, this.methods);
        }
    }
}