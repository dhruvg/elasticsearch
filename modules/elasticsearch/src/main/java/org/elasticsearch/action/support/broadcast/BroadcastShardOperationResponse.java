/*
 * Licensed to Elastic Search and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Elastic Search licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.action.support.broadcast;

import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.io.stream.Streamable;

import java.io.IOException;

/**
 * @author kimchy (Shay Banon)
 */
public abstract class BroadcastShardOperationResponse implements Streamable {

    String index;

    int shardId;

    protected BroadcastShardOperationResponse() {

    }

    protected BroadcastShardOperationResponse(String index, int shardId) {
        this.index = index;
        this.shardId = shardId;
    }

    public String index() {
        return this.index;
    }

    public String getIndex() {
        return index();
    }

    public int shardId() {
        return this.shardId;
    }

    public int getShardId() {
        return shardId();
    }

    @Override public void readFrom(StreamInput in) throws IOException {
        index = in.readUTF();
        shardId = in.readVInt();
    }

    @Override public void writeTo(StreamOutput out) throws IOException {
        out.writeUTF(index);
        out.writeVInt(shardId);
    }
}