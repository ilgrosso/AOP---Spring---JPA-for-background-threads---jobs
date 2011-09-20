package com.blogspot.chicchiricco.util.jobs.impl;

import com.blogspot.chicchiricco.persistence.TestEntity;
import com.blogspot.chicchiricco.persistence.dao.TestEntityDAO;
import java.util.Calendar;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test job that runs on the background.
 */
public class TestBackgroundJobImpl implements Runnable {

    private final static Logger LOG = LoggerFactory.getLogger(
            TestBackgroundJobImpl.class);

    private TestEntityDAO testEntityDAO;

    public void setTestEntityDAO(final TestEntityDAO testEntityDAO) {
        this.testEntityDAO = testEntityDAO;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void run() {
        LOG.debug("doing something in the background ");

        TestEntity testEntity = new TestEntity();
        testEntity.setId(Calendar.getInstance().getTimeInMillis());
        testEntityDAO.save(testEntity);
        LOG.debug("Entities PRE: " + testEntityDAO.findAll());

        if (new Random(Calendar.getInstance().getTimeInMillis()).nextBoolean()) {
            LOG.debug("Exception expected here");
            testEntityDAO.save(new TestEntity());
        }

        LOG.debug("Entities POST: " + testEntityDAO.findAll());
    }
}
