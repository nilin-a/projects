package com.company;

import java.util.*;

class OrderService {
    enum Type {DELIVERY, PICKUP}

    static class OrderData {
        final Type type;
        final String currency;
        final Long amount;

        OrderData (Type type,
                   String currency,
                   Long amount) {
            this.type = type;
            this.currency = currency;
            this.amount = amount;
        }

        String getCurrency() {
            return currency;
        }

        Long getAmount() {
            return amount;
        }

        Type getType() {
            return type;
        }
    }

    public static class SubObject {
        public Long maxAmount;
        public Long minAmount;

        public SubObject(Long maxAmount, Long minAmount) {
            this.maxAmount = maxAmount;
            this.minAmount = minAmount;
        }
    }

    public static Map<String, Double> getMaxMinusMinDeliveryMapByCurrency(List<OrderData> orderDataList) {
        Map<String, SubObject> differenceMap = new HashMap<>();
        for (OrderData data : orderDataList) {
            if (data.type != Type.DELIVERY) {
                continue;
            }
            if (!differenceMap.containsKey(data.currency)) {
                differenceMap.put(data.currency, new SubObject(data.amount, data.amount));
            } else {
                SubObject subObj = differenceMap.get(data.currency);
                if (data.amount > subObj.maxAmount) {
                    subObj.maxAmount = data.amount;
                } else if (data.amount < subObj.minAmount){
                    subObj.minAmount = data.amount;
                }
            }
        }
        Map<String, Double> maxMinusMinDeliveryMapByCurrency = new HashMap<>();
        differenceMap.forEach((String currency, SubObject subObject) -> {
            maxMinusMinDeliveryMapByCurrency.put(currency, (double)(subObject.maxAmount - subObject.minAmount));
        } );


        return maxMinusMinDeliveryMapByCurrency;
    }
}
