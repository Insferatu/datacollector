/**
 * Copyright 2016 StreamSets Inc.
 *
 * Licensed under the Apache Software Foundation (ASF) under one
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
package com.streamsets.pipeline.stage.destination.hdfs.metadataxecutor;

import com.streamsets.pipeline.api.ConfigDefBean;
import com.streamsets.pipeline.api.ConfigGroups;
import com.streamsets.pipeline.api.Executor;
import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.StageDef;
import com.streamsets.pipeline.configurablestage.DExecutor;

//@StageDef(
//  version = 1,
//  label = "HDFS File Metadata",
//  description = "Changes HDFS file metadata such as renaming files or changing permissions.",
//  icon = "hdfs.png",
//  privateClassLoader = true,
//  onlineHelpRefUrl = "index.html#Executors/HDFSMetadata.html#task_m3v_5lk_fx",
//  producesEvents = true
//)
@ConfigGroups(value = Groups.class)
@GenerateResourceBundle
public class HdfsMetadataDExecutor extends DExecutor {

  @ConfigDefBean
  public HdfsConnectionConfig connection;

  @ConfigDefBean
  public HdfsActionsConfig  actions;

  @Override
  protected Executor createExecutor() {
    return new HdfsMetadataExecutor(connection, actions);
  }
}