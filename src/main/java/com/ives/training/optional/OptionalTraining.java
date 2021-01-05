package com.ives.training.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @DESCRIPTION:
 * @AUTHOR: ives
 * @DATE: 2021/1/5 13:27
 */
public class OptionalTraining {
    public void getXXX(Map<String, String> params) {
        Map<String, String> map = Optional.ofNullable(params).orElse(new HashMap<>());
    }

}
