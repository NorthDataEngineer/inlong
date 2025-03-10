/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.sort.formats.inlongmsg;

import org.apache.inlong.sort.formats.base.TableFormatConstants;
import org.apache.inlong.sort.formats.base.TableFormatUtils;

import org.apache.flink.table.descriptors.DescriptorProperties;
import org.apache.flink.table.descriptors.DescriptorValidator;

/**
 * Validator for mixed inlongmsg formats.
 */
public class InLongMsgValidator implements DescriptorValidator {

    @Override
    public void validate(DescriptorProperties properties) {
        TableFormatUtils.getValidateProperties(properties);
        properties.validateString(TableFormatConstants.FORMAT_DELIMITER, true, 1, 1);
        properties.validateString(TableFormatConstants.FORMAT_ENTRY_DELIMITER, true, 1, 1);
        properties.validateString(TableFormatConstants.FORMAT_KV_DELIMITER, true, 1, 1);
        properties.validateString(TableFormatConstants.FORMAT_QUOTE_CHARACTER, true, 1, 1);
        properties.validateBoolean(TableFormatConstants.FORMAT_IGNORE_ERRORS, true);

        TableFormatUtils.validateSchema(properties);
    }
}
