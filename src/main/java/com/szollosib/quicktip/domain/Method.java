package com.szollosib.quicktip.domain;

public enum Method {
    FIRST_METHOD(1),
    SECOND_METHOD(2),
    THIRD_METHOD(3);

    private Integer methodValue;

    Method(Integer methodValue) {
        this.methodValue = methodValue;
    }

    public Integer value() {
        return this.methodValue;
    }

    public static Method getByValue(Integer methodValue) {
        for (Method method : Method.values()){
            if (method.value().equals(methodValue)) {
                return method;
            }
        }
        return null;
     }
}
