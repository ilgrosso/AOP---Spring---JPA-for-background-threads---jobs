/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package com.blogspot.chicchiricco.persistence.dao.impl;

import com.blogspot.chicchiricco.persistence.TestEntity;
import com.blogspot.chicchiricco.persistence.dao.TestEntityDAO;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TestEntityDAOImpl extends AbstractDAOImpl
        implements TestEntityDAO {

    @Override
    public TestEntity find(final Long id) {
        return entityManager.find(TestEntity.class, id);
    }

    @Override
    public List<TestEntity> findAll() {
        Query query = entityManager.createQuery(
                "SELECT e FROM TestEntity e");

        return query.getResultList();
    }

    @Override
    public TestEntity save(final TestEntity testEntity)
            throws RuntimeException {

        if (testEntity.getId() == null) {
            throw new RuntimeException();
        }

        return entityManager.merge(testEntity);
    }

    @Override
    public void delete(final Long id) {
        TestEntity testEntity = find(id);
        if (testEntity == null) {
            return;
        }

        entityManager.remove(testEntity);
    }
}
