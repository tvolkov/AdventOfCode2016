package com.company.day8;

import java.util.Map;

public interface Command {
    CommandType getType();
    Map<String, Integer> getParams();
}
