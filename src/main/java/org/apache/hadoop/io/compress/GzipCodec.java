/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.io.compress;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.compress.zlib.BuiltInGzipDecompressor;

/**
 * This class creates gzip compressors/decompressors. 
 */
public class GzipCodec implements CompressionCodec {
  Configuration conf;

  public CompressionOutputStream createOutputStream(OutputStream out) 
    {
    return null;
  }
  
  public CompressionOutputStream createOutputStream(OutputStream out, 
                                                    Compressor compressor) {
    return (compressor != null) ?
               new CompressorStream(out, compressor,
                                    4096) :
               createOutputStream(out);
  }

  public Compressor createCompressor() {
    return null;
  }

  public Class<? extends Compressor> getCompressorType() {
    return null;
  }

  public CompressionInputStream createInputStream(InputStream in)
      throws IOException {
    return null;
  }

  public CompressionInputStream createInputStream(InputStream in,
                                                  Decompressor decompressor)
  throws IOException {
    if (decompressor == null) {
      decompressor = createDecompressor();  // always succeeds (or throws)
    }
    return new DecompressorStream(in, decompressor,
                                  4096);
  }

  public Decompressor createDecompressor() {
    return new BuiltInGzipDecompressor();
  }

  public Class<? extends Decompressor> getDecompressorType() {
    return BuiltInGzipDecompressor.class;
  }

}
