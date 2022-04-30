package com.csye7200.application.services;

import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CosineSimilrityServiceTest {

    @Test
    public void cosineTest(){
        Vector a = Vectors.dense(1.0, 0.0, 3.0);
        Vector b = Vectors.dense(1.0, 0.0, 3.0);
        CosineSimilrityService cosineSimilrityService = new CosineSimilrityService();
        assertEquals(0.9999999999999998,cosineSimilrityService.cosine(a,b));
    }

    @Test
    public void cosineTestNegative(){
        Vector a = Vectors.dense(1.0, 0.0, 3.0);
        Vector b = Vectors.dense(5.0, 6.0, 2.0);
        CosineSimilrityService cosineSimilrityService = new CosineSimilrityService();
        assertEquals(0.43145549730400484,cosineSimilrityService.cosine(a,b));
    }

}