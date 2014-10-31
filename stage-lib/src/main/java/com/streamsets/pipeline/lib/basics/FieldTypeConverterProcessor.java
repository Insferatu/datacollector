/**
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
package com.streamsets.pipeline.lib.basics;

import com.streamsets.pipeline.api.*;
import com.streamsets.pipeline.api.ConfigDef.Type;
import com.streamsets.pipeline.api.base.SingleLaneRecordProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@StageDef(name = "fieldTypeConverter", version="1.0.0", label="Field Type Converter")
public class FieldTypeConverterProcessor extends SingleLaneRecordProcessor {

  public static class ConverterValuesProvider implements ValuesProvider {
    @Override
    public List<String> getValues() {
      List<String> values = new ArrayList<String>();
      for (Field.Type type : Field.Type.values()) {
        values.add(type.toString());
      }
      return values;
    }

    @Override
    public List<String> getLabels() {
      List<String> labels = new ArrayList<String>();
      for (Field.Type type : Field.Type.values()) {
        labels.add(type.name());
      }
      return labels;
    }
  }

  @ConfigDef(name = "fieldsToConvert", label = "Fields to convert", required = true,type = Type.MODEL, defaultValue="")
  @FieldModifier(type= FieldModifier.Type.PROVIDED, valuesProvider = ConverterValuesProvider.class)
  public Map<String, String> fields;

  // the annotations processor will fail if variable is not Map

  /* bundle
   stage.label=
   stage.description=
   config.#NAME#.label=
   config.#NAME#.description=
   config.#NAME#.value.BOOLEAN=
   config.#NAME#.value.BYTE=
   config.#NAME#.value.CHAR=
   config.#NAME#.value.INTEGER=
   config.#NAME#.value.LONG=
   */

  @Override
  protected void process(Record record, SingleLaneBatchMaker batchMaker) throws StageException {

  }
}
