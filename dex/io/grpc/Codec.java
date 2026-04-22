package io.grpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public interface Codec extends Compressor, Decompressor {

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Gzip implements Codec {
        @Override // io.grpc.Compressor, io.grpc.Decompressor
        public String getMessageEncoding() {
            return "gzip";
        }

        @Override // io.grpc.Compressor
        public OutputStream compress(OutputStream os) throws IOException {
            return new GZIPOutputStream(os);
        }

        @Override // io.grpc.Decompressor
        public InputStream decompress(InputStream is) throws IOException {
            return new GZIPInputStream(is);
        }
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Identity implements Codec {
        public static final Codec NONE = new Identity();

        @Override // io.grpc.Decompressor
        public InputStream decompress(InputStream is) {
            return is;
        }

        @Override // io.grpc.Compressor, io.grpc.Decompressor
        public String getMessageEncoding() {
            return "identity";
        }

        @Override // io.grpc.Compressor
        public OutputStream compress(OutputStream os) {
            return os;
        }

        private Identity() {
        }
    }
}