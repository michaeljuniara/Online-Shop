public class Voucher {
    private String code;
    private double nominal; 
    private int remainingUsage;

    public Voucher(String code, double nominal, int maxUsage) {
        this.code = code;
        this.nominal = nominal;
        remainingUsage = maxUsage;
    }

    public String getCode() {
        return this.code;
    }

    public boolean isValid() {
        return remainingUsage > 0;
    }

    public double use() {
        if (isValid()) return nominal;
        else return 0.0;
    }
}
