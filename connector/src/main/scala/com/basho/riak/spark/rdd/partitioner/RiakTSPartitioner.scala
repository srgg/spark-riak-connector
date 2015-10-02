/**
 * Copyright (c) 2015 Basho Technologies, Inc.
 *
 * This file is provided to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain
 * a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.basho.riak.spark.rdd.partitioner

import com.basho.riak.client.core.util.HostAndPort
import com.basho.riak.spark.rdd.RiakPartition
import org.apache.spark.Partition

case class RiakTSPartition (
      index: Int,
      endpoints: Iterable[HostAndPort],
      query: String
  ) extends RiakPartition

/**
 * Dumb implementation of single partition partitioner
 */
object RiakTSPartitioner {
  def partitions(endpoints: Iterable[HostAndPort], query: String): Array[Partition] = {
    Array(new RiakTSPartition(0, endpoints, query))
  }
}
