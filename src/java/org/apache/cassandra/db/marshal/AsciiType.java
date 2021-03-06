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
package org.apache.cassandra.db.marshal;

import java.nio.ByteBuffer;

import org.apache.cassandra.cql3.CQL3Type;
import org.apache.cassandra.serializers.TypeSerializer;
import org.apache.cassandra.serializers.AsciiSerializer;
import org.apache.cassandra.serializers.MarshalException;

public class AsciiType extends AbstractType<String>
{
    public static final AsciiType instance = new AsciiType();

    AsciiType() {} // singleton

    public int compare(ByteBuffer o1, ByteBuffer o2)
    {
        return BytesType.bytesCompare(o1, o2);
    }

    public ByteBuffer fromString(String source)
    {
        return decompose(source);
    }

    public CQL3Type asCQL3Type()
    {
        return CQL3Type.Native.ASCII;
    }

    public TypeSerializer<String> getSerializer()
    {
        return AsciiSerializer.instance;
    }
}
