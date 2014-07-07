/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ca.mariusbogoevici.springxd.mongo.source;

import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.xd.tuple.Tuple;
import org.springframework.xd.tuple.TupleBuilder;

/**
 * @author: Marius Bogoevici
 */
public class TupleReadConverter implements Converter<DBObject, Tuple> {

    @Override
    public Tuple convert(DBObject source) {

        TupleBuilder tupleBuilder = new TupleBuilder();
        for (String key : source.keySet()) {
            if ("_id".equals(key)) {
                tupleBuilder.put("id", source.get(key));
            } else {
                tupleBuilder.put(key, source.get(key));
            }
        }

        return tupleBuilder.build();
    }
}
