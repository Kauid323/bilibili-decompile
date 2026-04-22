package okhttp3.internal.platform;

import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

/* JADX INFO: Access modifiers changed from: package-private */
public class Android10Platform extends AndroidPlatform {
    Android10Platform(Class<?> sslParametersClass) {
        super(sslParametersClass, null, null, null, null);
    }

    @Override // okhttp3.internal.platform.AndroidPlatform, okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<Protocol> protocols) throws IOException {
        try {
            enableSessionTickets(sslSocket);
            SSLParameters sslParameters = sslSocket.getSSLParameters();
            String[] protocolsArray = (String[]) Platform.alpnProtocolNames(protocols).toArray(new String[0]);
            sslParameters.setApplicationProtocols(protocolsArray);
            sslSocket.setSSLParameters(sslParameters);
        } catch (IllegalArgumentException iae) {
            throw new IOException("Android internal error", iae);
        }
    }

    private void enableSessionTickets(SSLSocket sslSocket) {
        if (SSLSockets.isSupportedSocket(sslSocket)) {
            SSLSockets.setUseSessionTickets(sslSocket, true);
        }
    }

    @Override // okhttp3.internal.platform.AndroidPlatform, okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(SSLSocket socket) {
        String alpnResult = socket.getApplicationProtocol();
        if (alpnResult == null || alpnResult.isEmpty()) {
            return null;
        }
        return alpnResult;
    }

    @Nullable
    public static Platform buildIfSupported() {
        if (Platform.isAndroid()) {
            try {
                if (getSdkInt() >= 29) {
                    Class<?> sslParametersClass = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
                    return new Android10Platform(sslParametersClass);
                }
            } catch (ClassNotFoundException e) {
            }
            return null;
        }
        return null;
    }
}