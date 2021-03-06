/**
 * Copyright (c) 2012-2019 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.corundumstudio.socketio.ack;

import java.util.UUID;

import com.corundumstudio.socketio.scheduler.SchedulerKey;

public class AckSchedulerKey extends SchedulerKey {

    private final long index;

    AckSchedulerKey(Type type, UUID sessionId, long index) {
        super(type, sessionId);
        this.index = index;
    }

    public long getIndex() {
        return index;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (int) (index ^ (index >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isObjectEqual = (this == obj);
        boolean isObjectNotEqualSuper = (!super.equals(obj));
        boolean isClassNotEqual = (getClass() != obj.getClass());
        AckSchedulerKey other = (AckSchedulerKey) obj;
        boolean isIndexNotEqual = (index != other.index);

        if ( isObjectEqual ) return true;
        if ( isObjectNotEqualSuper || isClassNotEqual || isIndexNotEqual ) return false;
        return true;
    }

}
