package opkarol.heroeswars.game.money;

public class Currency {
    String format;
    String currency;
    int startMoney;

    public Currency(String currency, String format, int startMoney){
        setCurrency(currency);
        setFormat(format);
        setStartMoney(startMoney);
    }

    public int getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(int startMoney) {
        this.startMoney = startMoney;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
