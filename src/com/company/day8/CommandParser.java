package com.company.day8;

import java.util.HashMap;
import java.util.Map;

class CommandParser {
    private static final String RECT = "rect";
    private static final String ROTATE_ROW = "rotate row";
    private static final String ROTATE_COLUMN = "rotate column";
    private static final String BY = "by";

    Command parseCommand(String strCommand) {
        CommandType commandType;
        Map<String, Integer> params = new HashMap<>();
        if (strCommand.startsWith(RECT)) {
            commandType = CommandType.RECT;
            params.putAll(parseRectParams(strCommand));
        } else if (strCommand.startsWith(ROTATE_ROW)) {
            commandType = CommandType.ROTATE_ROW;
            params.putAll(parseRotateRowParams(strCommand));
        } else if (strCommand.startsWith(ROTATE_COLUMN)) {
            commandType = CommandType.ROTATE_COLUMN;
            params.putAll(parseRotateColumnParams(strCommand));
        } else {
            throw new RuntimeException("invalid command");
        }

        return new Command() {
            @Override
            public CommandType getType() {
                return commandType;
            }

            @Override
            public Map<String, Integer> getParams() {
                return params;
            }
        };
    }

    private Map<String, Integer> parseRotateColumnParams(String strCommand) {
        Map<String, Integer> result = new HashMap<>();
        String paramStr = strCommand.substring(ROTATE_COLUMN.length() + 1);
        result.put("x", Integer.parseInt(paramStr.substring(2, 3)));
        result.put("y", Integer.parseInt(paramStr.substring(paramStr.indexOf(BY) + BY.length() + 1)));
        return result;
    }

    private Map<String, Integer> parseRotateRowParams(String strCommand) {
        Map<String, Integer> result = new HashMap<>();
        String paramStr = strCommand.substring(ROTATE_ROW.length() + 1);
        result.put("y", Integer.parseInt(paramStr.substring(2, 3)));
        result.put("x", Integer.parseInt(paramStr.substring(paramStr.indexOf(BY) + BY.length() + 1)));
        return result;
    }

    private Map<String, Integer> parseRectParams(String strCommand) {
        Map<String, Integer> result = new HashMap<>();
        String paramsStr = strCommand.substring(RECT.length() + 1);
        result.put("x", Integer.parseInt(paramsStr.substring(0, 1)));
        result.put("y", Integer.parseInt(paramsStr.substring(2)));
        return result;
    }

}
