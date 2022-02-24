package com.csp.notes.service;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author csp
 * @date 2022/2/22 20:09
 * @description
 */
@Service
public class LabelService {
    public String generateLabel(){
        Random random = new Random(System.currentTimeMillis());
        return String.valueOf(random.nextInt(10000));
    }
}
