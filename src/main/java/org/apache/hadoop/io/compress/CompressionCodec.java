package org.apache.hadoop.io.compress;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface CompressionCodec {
    Decompressor createDecompressor();
    Compressor createCompressor();
    CompressionInputStream createInputStream(InputStream is, Decompressor d) throws IOException;
    CompressionOutputStream createOutputStream(OutputStream os, Compressor c);
}
