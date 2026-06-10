package org.example.Entity;

public class Voucher {
    private String code;
    private double nominal;
    private int remainingUsage;

    public Voucher(String code, double nominal, int maxUsage) {
        this.code = code;
        this.nominal = nominal;
        remainingUsage = maxUsage;
    }

    public double use() {
        if (isValid()) {
            --remainingUsage;
            return nominal;
        } else return 0.0;
    }

    public String getCode() {
        return this.code;
    }

    public boolean isValid() {
        return remainingUsage > 0;
    }
}
